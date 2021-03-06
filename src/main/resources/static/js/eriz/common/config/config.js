var prefix = "/common/config";
$(function () {
    var tableIns;//定义data-table全局名称
});

reload = function () {
    tableIns.reload({
        page: {
            curr: 1 //重新从第 1 页开始
        }
    })
};

function add() {
    layer.open({
        type : 2,
        title : '添加',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '480px' ],
        content : prefix + '/add'
    });
}

function edit(index) {
    layer.open({
        type : 2,
        title : '编辑',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '480px' ],
        content : prefix +'/add?keyValue=' + index
    });
}

function remove(index){
    $.ajax({
        url : prefix + '/remove',
        type : "post",
        data : {
            'id' : index
        },
        success : function(data) {
            if (data.code === 0) {
                layer.msg(data.message);
                tableIns.reload({
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                });
            } else {
                layer.msg(data.message);
            }
        }
    });
}

function batchRemove(){
    var values = batchRemoveValue();
    $.ajax({
        url : prefix + '/batchRemove',
        type : "post",
        data : {
            'ids' : values
        },
        success : function(data) {
            if (data.code === 0) {
                layer.msg(data.message);
                tableIns.reload({
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                });
            } else {
                layer.msg(data.message);
            }
        }
    });
}
layui.use(['layer', 'table', 'element'], function(){
    var  layer = layui.layer,table = layui.table;

    tableIns = table.render({
        elem: '#table-data'
        ,height: 420
        ,url: prefix +'/list' //数据接口
        ,method: 'POST'
        ,title: ''
        ,page: true //开启分页
        ,id: 'table-reload'
        ,toolbar: false //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
        ,totalRow: false //开启合计行
        ,cols: [[ //表头
            {type: 'checkbox'},
			                {
                    field : 'id',
                    title : 'id'
                },
			                {
                    field : 'k',
                    title : '键'
                },
			                {
                    field : 'v',
                    title : '值'
                },
			                {
                    field : 'remark',
                    title : '备注'
                },
			                {
                    field : 'createtime',
                    title : '创建时间'
                },
			                {
                    field : 'kvtype',
                    title : ''
                },
				{fixed: 'right', align:'center', toolbar: '#bar'}
        ]]
    });
    //搜索框重载
    var $ = layui.$, active = {
        reload: function(){
            var name = $('#name').val();
            table.reload('table-reload', {
                where: {
                    'keyword': name
                },
                method: 'POST'
            });
        }
    };

    $('#btn-search').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    //批量删除
    window.batchRemoveValue = function(){
        var checkStatus = table.checkStatus('table-reload');
        var ids = new Array();
        $.each(checkStatus.data,function(key,value){
            ids[key] = value['id'];
        });
        if (ids.length <= 0) {
            layer.msg('请选择要删除的行');
            return;
        }
        return ids;
    };

    //监听行工具事件
    table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            ,layEvent = obj.event; //获得 lay-event 对应的值
        if(layEvent === 'detail'){
            layer.msg('查看操作');
        } else if(layEvent === 'del'){
            layer.confirm('真的删除行么', function(index){
                layer.close(index);
                //向服务端发送删除指令
                remove(data.id);
            });
        } else if(layEvent === 'edit'){
            edit(data.id);
        }
    });
});