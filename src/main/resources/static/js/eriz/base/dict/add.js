$(function (){
});


layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form ,layer = layui.layer;

    //监听提交
    form.on('submit(submit)', function(){
        $.ajax({
            cache : true,
            type : "POST",
            url : "/base/dict/save",
            data : $('#signupForm').serialize(),// 你的formid
            async : false,
            error : function(request) {
                parent.layer.alert("Connection error");
            },
            success : function(data) {
                if (data.code === 0) {
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