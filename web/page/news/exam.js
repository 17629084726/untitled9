layui.use(['form','layer','layedit','laydate','upload'],function(){
    var form = layui.form
    layer = parent.layer === undefined ? layui.layer : top.layer,
        laypage = layui.laypage,
        upload = layui.upload,
        layedit = layui.layedit,
        laydate = layui.laydate,
        $ = layui.jquery;
    var UserName=window.sessionStorage.getItem("user");
    var userId=window.sessionStorage.getItem("id");
    $("#userName").val(UserName);
    $("#userId").val(userId);

    //用于同步编辑器内容到textarea
    layedit.sync(editIndex);


}