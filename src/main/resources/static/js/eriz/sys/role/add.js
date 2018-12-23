$(function (){
    var keyValue = $("#rId").val();
    menuTree(keyValue);
});

function menuTree(keyValue) {
    var setting = {
        view: {
            showLine: false
        },
        check: {
            enable: true,
            chkStyle: "checkbox"
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            beforeCheck:true
        }
    };
    $.ajax({
        url: "/sys/menu/menuTree?keyValue=" + keyValue,
        success: function(data){
            $.fn.zTree.init($("#menuTree"), setting, data);
        }
    })
}



function getMenuId(){
    var menuIds = new Array();
    var treeObj = $.fn.zTree.getZTreeObj("menuTree");
    var nodes = treeObj.getCheckedNodes(true);//在提交表单之前将选中的checkbox收集
    for(var i=0;i<nodes.length;i++){
        menuIds.push(nodes[i].id);
    }
    return menuIds;
}


layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form ,layer = layui.layer;

    //自定义验证规则
    form.verify({
        roleName: function(value){
            if(value.length < 1){
                return '名称不能为空';
            }
        }
    });

    //监听提交
    form.on('submit(demo1)', function(data){
        $("#menuIds").val(getMenuId());
        $.ajax({
            cache : true,
            type : "POST",
            url : "/sys/role/save",
            data : $('#signupForm').serialize(),// 你的formid
            async : false,
            error : function(request) {
                parent.layer.alert("Connection error");
            },
            success : function(data) {
                if (data.code == 0) {
                    // 关闭弹窗，刷新数据表格
                    parent.layer.msg(data.message);
                    var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                    parent.layer.close(index);
                    parent.layui.table.reload('table-reload',{page:{curr:1}});
                } else {
                    parent.layer.alert(data.message)
                }
            }
        });
        return false;
    });
});