/*
* 角色模块js
*
* */
$(function () {
    var tableIns;
});

function add() {
    layer.open({
        type : 2,
        title : '添加标签',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '480px' ],
        content : '/base/dict/add'
    });
}

function edit(index) {
    layer.open({
        type : 2,
        title : '编辑标签',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '480px' ],
        content : '/base/dict/add?keyValue=' + index
    });
}

function remove(index){
    $.ajax({
        url : "/base/dict/remove",
        type : "post",
        data : {
            'ids' : index
        },
        success : function(data) {
            console.log(data)
            if (data.code == 0) {
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
    var  layer = layui.layer //弹层
        ,table = layui.table; //表格

    //执行一个 table 实例
    tableIns = table.render({
        elem: '#table-data'
        ,height: 420
        ,url: 'list' //数据接口
        ,method: 'POST'
        ,title: '字典表'
        ,page: true //开启分页
        ,id: 'table-reload'
        ,toolbar: false //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
        ,totalRow: false //开启合计行
        ,cols: [[ //表头
            {type: 'checkbox', fixed: 'left'}
            ,{field: 'id', title: 'ID', width:80, sort: true, fixed: 'left', totalRowText: '合计：'}
            ,{field: 'name', title: '名称', width:80}
            ,{field: 'value', title: '数据值', width:80}
            ,{field: 'type', title: '类型', width:80, sort: true}
            ,{field: 'description', title: '描述', width:80, sort: true}
            ,{field: 'remarks', title: '备注', width:80, sort: true}
            ,{fixed: 'right', width: 165, align:'center', toolbar: '#barDemo'}
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

    //获取选择行
    $('#btn-delete').on('click', function(){
        var checkStatus = table.checkStatus('table-reload'); //idTest 即为基础参数 id 对应的值
        var ids = "";
        $.each(checkStatus.data,function(key,value){
            ids +=  "," + value.id
        })
        remove(ids);
    });


    //监听头工具栏事件
    table.on('toolbar(test)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id)
            ,data = checkStatus.data; //获取选中的数据
        switch(obj.event){
            case 'add':
                layer.msg('添加');
                break;
            case 'update':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else if(data.length > 1){
                    layer.msg('只能同时编辑一个');
                } else {
                    layer.alert('编辑 [id]：'+ checkStatus.data[0].id);
                }
                break;
            case 'delete':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else {
                    layer.msg('删除');
                }
                break;
        };
    });

    //监听行工具事件
    table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            ,layEvent = obj.event; //获得 lay-event 对应的值
        if(layEvent === 'detail'){
            console.log(data)
            layer.msg('查看操作');
        } else if(layEvent === 'del'){
            layer.confirm('真的删除行么', function(index){
                obj.del(); //删除对应行（tr）的DOM结构
                layer.close(index);
                //向服务端发送删除指令
                remove(data.id);
            });
        } else if(layEvent === 'edit'){
            edit(data.id);
        }
    });
});