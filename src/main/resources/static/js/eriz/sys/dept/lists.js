$(function () {
});

layui.config({
    base: '/layui/'
}).extend({
    treetable: 'treetable'
}).use(['layer', 'table', 'treetable'], function () {
    var $ = layui.jquery;
    var table = layui.table;
    var layer = layui.layer;
    var treetable = layui.treetable;

    // 渲染表格
    window.renderTable = function (index) {
        layer.load(2);
        treetable.render({
            treeColIndex: 1,
            treeSpid: 0,
            treeIdName: 'id',
            treePidName: 'parentId',
            treeDefaultClose: true,
            treeLinkage: false,
            elem: '#table-tree',
            data: index,
            page: false,
            cols: [[
                {type: 'numbers'},
                {field: 'name', title: '部部门名称'},
                {field: 'orderNum', title: '排序'},
                {field: 'delFlag', title: '状态'},
                {templet: '#oper-col', title: '操作'}
            ]],
            done: function () {
                layer.closeAll('loading');
            }
        });
    };

    menuData('');

    $('#btn-expand').click(function () {
        treetable.expandAll('#table-tree');
    });

    $('#btn-fold').click(function () {
        treetable.foldAll('#table-tree');
    });

    $('#btn-refresh').click(function () {
        menuData('');
    });

    //监听工具条
    table.on('tool(table-tree)', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'del') {
            layer.confirm('真的删除行么', function (index) {
                layer.close(index);
                //向服务端发送删除指令
                remove(data.id);
            });
        } else if (layEvent === 'edit') {
            add(data.id, "");
        } else if (layEvent === 'add') {
            add("", data.id);
        }
    });

    remove = function (index) {
        $.ajax({
            url: "/sys/dept/remove",
            type: "post",
            data: {
                'id': index
            },
            success: function (data) {
                if (data.code === 0) {
                    layer.msg(data.message);
                    menuData('')
                } else {
                    layer.msg(data.message);
                }
            }
        });
    };
});

var search = function () {
    var keyValue = $('#search').val();
    menuData(keyValue)
}

var menuData = function (keyValue) {
    $.ajax({
        url: "/sys/dept/deptTreeJson?keyValue=" + keyValue,
        type: "get",
        success: function (data) {
            renderTable(JSON.parse(data))
        }
    });
};
var add = function (keyValue, pId) {
    layer.open({
        type: 2,
        title: '添加菜单',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '480px'],
        content: '/sys/dept/add?keyValue=' + keyValue + '&pId=' + pId
    });
}