$(function () {
    initTree();
});

initTree = function () {
    var setting = {
        view: {
            showLine: false
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            beforeClick: beforeClick,
            onClick: function(treeId, treeNode) {
                var treeObj = $.fn.zTree.getZTreeObj(treeNode);
                var selectedNode = treeObj.getSelectedNodes()[0];
                console.log(selectedNode.id+selectedNode.name)
                reloadTree(selectedNode.id);
            }

        }
    };
    $.ajax({
        url: "/sys/dept/deptTree",
        success: function(data){
            var treeObj = $.fn.zTree.init($("#deptTree"), setting, data);
            treeObj.expandAll(true);
        }
    })
}

//点击之前触发事件
function beforeClick(treeId,treeNode,clickFlag){
    if(treeNode.isParent){
        //alert("当前是子节点，不能操作!")
        return false;
    }
    return true;
}

//选择树触发函数
reloadTree = function (treeId) {
    $.ajax({
        url: "/sys/user/userList?deptId=" + treeId,
        type: "post",
        success: function (data) {
            renderTable(data.data)
        }
    });
}
function add() {
    layer.open({
        type : 2,
        title : '增加用户',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '480px' ],
        content : '/sys/user/add'
    });
}

function edit(index) {
    layer.open({
        type : 2,
        title : '编辑用户',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '480px' ],
        content : '/sys/user/add?uid=' + index
    });
}

function remove(index){
    $.ajax({
        url : "/sys/user/remove",
        type : "post",
        data : {
            'ids' : index
        },
        success : function(r) {
            if (r.code == 0) {
                layer.msg(r.msg);
                //reLoad();
            } else {
                layer.msg(r.msg);
            }
        }
    });
}
layui.use(['layer', 'table', 'element'], function(){
    var  layer = layui.layer //弹层
        ,table = layui.table; //表格

    //执行一个 table 实例
    window.renderTable = function(data){
        table.render({
            elem: '#table-data'
            ,height: 420
            // ,url: 'userList' //数据接口
            ,method: 'POST'
            ,title: '用户表'
            ,page: true //开启分页
            ,id: 'testReload'
            ,toolbar: false //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            ,totalRow: false //开启合计行data
            ,data: data
            ,cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                ,{field: 'id', title: 'ID', hidden: true, width:80, sort: true, fixed: 'left', totalRowText: '合计：'}
                ,{field: 'name', title: '姓名', width:80}
                ,{field: 'username', title: '用户名', width:80}
                ,{field: 'email', title: '邮箱', width:80, sort: true}
                ,{field: 'deptId', title: '部门', width:80, sort: true}
                ,{field: 'sex', title: '性别', width:80, sort: true}
                ,{field: 'city', title: '城市', width:150}
                ,{fixed: 'right', width: 165, align:'center', toolbar: '#barDemo'}
            ]]
        });
    };
    reloadTree('');
    //搜索框重载
    var $ = layui.$, active = {
        reload: function(){
            var name = $('#name').val();
            console.log(name)
            table.reload('testReload', {
                where: {
                    'name': name
                },
                method: 'POST',
                url:'/sys/user/userList'
            });
        }
    };

    $('#btn-search').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    //获取选择行
    $('#btn-delete').on('click', function(){
        var checkStatus = table.checkStatus('testReload'); //idTest 即为基础参数 id 对应的值
        // remove(checkStatus.data);
        var ids = "";
        $.each(checkStatus.data,function(key,value){
            ids +=  "," + value.id
        })
        remove(ids);
        console.log(checkStatus.data) //获取选中行的数据
        console.log(checkStatus.data.length) //获取选中行数量，可作为是否有选中行的条件
        console.log(checkStatus.isAll ) //表格是否全选
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