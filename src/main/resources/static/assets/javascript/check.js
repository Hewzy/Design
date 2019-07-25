$(document).ready(function(){
    function checkAll(){
        if ($(':checkbox').is(':checked')) {
            if($("input:checked").length === 1){
                //选中一个，启用相应按钮
                $("#return").attr('disabled',false);
                $("#exchange").attr('disabled',false);
                $("#MyAbnormalModel").attr('disabled',false);
                $("#checked").attr('disabled',false);
                $("#outstock").attr('disabled',false);
                $("#route").attr('disabled',false);
            }
            else {
                $("#return").attr('disabled',true);
                $("#exchange").attr('disabled',true);
                $("#MyAbnormalModel").attr('disabled',true);
                $("#checked").attr('disabled',true);
                $("#outstock").attr('disabled',false);
                $("#route").attr('disabled',false);
            }
        }
        else {
            $("#exchange").attr('disabled',true);
            $("#return").attr('disabled',true);
            $("#MyAbnormalModel").attr('disabled',true);
            $("#outstock").attr('disabled',true);
            $("#route").attr('disabled',true);
            $("#checked").attr('disabled',true);
        }
    }
   $(document).on('click',"input[type='checkbox']",function(){
       checkAll(this);
   });
    window.onload=checkAll;
});