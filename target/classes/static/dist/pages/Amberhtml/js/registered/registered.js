function registered_jiaoyan() {
    var kk = emailjiaoyan($("#email").val());
    return kk;
}


function emailjiaoyan(obj) { //邮箱正则校验
    var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$"); //正则表达式
    alert(obj.value);
    if (obj == "") { //输入不能为空
        alert("输入不能为空!");
        return false;
    } else if (!reg.test(obj)) { //正则验证不通过，格式不对
        alert("验证不通过!");
        return false;
    } else {
        // alert("通过！");
        return true;
    }
}