$(document).ready(function () {
    // 加减控件的封装
    function addFun(objAdd) {
        var txtnum = objAdd.prev();
        num = parseInt(txtnum.val());
        num++;
        if (num > 99) {
            num = 99;
            objAdd.attr('disabled',true);
        } else if (num >= 0 && num <= 99) {
            objAdd.attr('disabled',false);
        }
        txtnum.prev().attr('disabled',false);
        txtnum.val(num);
    }
    function reduceFun(objRaduce) {
        var txtnum = objRaduce.next();
        num = parseInt(txtnum.val());
        num--;
        if (num < 0) {
            num =0;
            objRaduce.attr('disabled',true);
        } else if (num >1) {
            objRaduce.attr('disabled',false);
        }
        txtnum.next().attr('disabled',false);
        txtnum.val(num);
    }
    $(".plus").click(function () {
        addFun($(this));
    }); 
    $(".subtract").click(function () {
        reduceFun($(this));
    });
});