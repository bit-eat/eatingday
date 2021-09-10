let tagModify = new Array();

function tag(){
    var tagOrigin = document.getElementById("tagList").value;
    var tagDelete = tagOrigin.replace(/(\s*)/g,"");
    tagModify = tagDelete.split('#',10);

    $.ajax({
        url:"/recipe/new",
        type: "post",
        data : {tagList : tagModify},
        success:function (data){
        console.log('성공');
        }, error :function (e){
            console.log(e);
        }
    })


}