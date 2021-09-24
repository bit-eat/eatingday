$(document).ready(function() {

    const btnRecommend = document.getElementById('recommend');
    const btnBookmark = document.getElementById('bookmark');

    //
    // $("#bookmark").click(function (){
    //     if($(this).attr('value') == '북마크'){
    //         btnBookmark.value='북마크취소';
    //     }else {
    //         btnBookmark.value='북마크';
    //     };
    // };
    $("input[id='bookmark']").on("click",function(){
        $("#checkbookmark").submit();
        $("input[id='bookmark']").hide();
        $("input[id='unbookmark']").show();
    });

    $("input[id='unbookmark']").on("click",function(){
        $("#checkunbookmark").submit();
        $("input[id='bookmark']").show();
        $("input[id='unbookmark']").hide();
    });
    function bookmark(){
        if($(this).attr('value') == '북마크'){
            btnBookmark.value='북마크취소';
        }else {
            btnBookmark.value='북마크';
        };
    }
    // function bookmark(id) {
    //     var form = document.createElement("form");
    //     form.setAttribute("method", "post");
    //     form.setAttribute("action", "/recipe/" + id + "/favorite");
    //     document.body.appendChild(form);
    //     form.submit();
    // }

});
