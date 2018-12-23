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
            elem: '#table1',
            data: index,
            page: false,
            cols: [[
                {type: 'numbers'},
                {field: 'name', title: '菜单名称'},
                {field: 'url', title: '菜单地址'},
                {field: 'perms', title: '权限'},
                {field: 'img', title: '图标'},
                {templet: '#oper-col', title: '操作'}
            ]],
            done: function () {
                layer.closeAll('loading');
            }
        });
    };

    menuData();

    $('#btn-expand').click(function () {
        treetable.expandAll('#table1');
    });

    $('#btn-fold').click(function () {
        treetable.foldAll('#table1');
    });

    $('#btn-refresh').click(function () {
        menuData();
    });

    //监听工具条
    table.on('tool(table1)', function (obj) {
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
            url: "/sys/menu/remove",
            type: "post",
            data: {
                'id': index
            },
            success: function (data) {
                if (data.code === 0) {
                    layer.msg(data.message);
                    menuData()
                } else {
                    layer.msg(data.message);
                }
            }
        });
    };
});
var menuData = function () {
    $.ajax({
        url: "/sys/menu/menuTreeJson",
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
        content: '/sys/menu/add?keyValue=' + keyValue + '&pId=' + pId
    });
}