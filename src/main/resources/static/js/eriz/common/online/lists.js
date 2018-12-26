/*
*  用户管理
* */
$(function () {

});

function remove(index){
    $.ajax({
        url : "/sys/online/remove",
        type : "post",
        data : {
            'ids' : index
        },
        success : function(data) {
            console.log(data)
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
    var  layer = layui.layer //弹层
        ,table = layui.table; //表格

    //执行一个 table 实例
    tableIns = table.render({
        elem: '#table-data'
        ,height: 420
        ,url: 'list' //数据接口
        ,method: 'POST'
        ,title: '日志列表'
        ,page: true //开启分页
        ,id: 'table-reload'
        ,toolbar: false //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
        ,totalRow: false //开启合计行
        ,cols: [[ //表头
            {type: 'checkbox', fixed: 'left'}
            ,{field: 'id', title: 'ID', width:80, sort: true, fixed: 'left', totalRowText: '合计：'}
            ,{field: 'username', title: '用户', width:80}
            ,{field: 'host', title: '地址', width:80}
            ,{field: 'startTimestamp', title: '开始时间', width:80}
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

    //监听行工具事件
    table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            ,layEvent = obj.event; //获得 lay-event 对应的值
        if(layEvent === 'del'){
            layer.confirm('确定要强制选中用户下线吗？', function(index){
                obj.del(); //删除对应行（tr）的DOM结构
                layer.close(index);
                //向服务端发送删除指令
                remove(data.id);
            });
        }
    });
});