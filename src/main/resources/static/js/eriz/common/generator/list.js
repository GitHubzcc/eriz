$(function () {

})
strategy = function(){
    layer.open({
        type: 2,
        title: '修改策略',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '480px'],
        content: 'strategyEdit'
    });
};

layui.use(['layer', 'table', 'element'], function(){
    var  layer = layui.layer //弹层
        ,table = layui.table; //表格

    tableIns = table.render({
        elem: '#table-data'
        ,height: 420
        ,url: 'list'
        ,method: 'POST'
        ,title: '代码生成'
        ,page: true
        ,id: 'table-reload'
        ,toolbar: false
        ,cols: [[
            {type: 'checkbox', fixed: 'left'}
            ,{field: 'tableName', title: '表名', sort: true, fixed: 'left'}
            ,{field: 'engine', title: 'engine'}
            ,{field: 'tableComment', title: '表描述'}
            ,{field: 'createTime', title: '创建时间',templet: function (r) {
                    return Format(r.createTime,'yyyy-MM-dd hh:mm:ss')
                }}
            ,{fixed: 'right', align:'center', toolbar: '#barDemo'}
        ]]
    });


    //监听行工具事件
    table.on('tool(test)', function(obj){
        var data = obj.data
            ,layEvent = obj.event;
        if(layEvent === 'code'){
            layer.confirm('确定生成代码？', function(index){
                layer.close(index)
                genCode(data.tableName)
            });
        }
    });

    genCode = function (tableName) {
        location.href = '/common/generator/code/'+tableName
    }
});