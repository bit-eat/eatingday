$(document).ready(function() {

    var check = $("input[id='checkid']").val();
    var checking = $("input[id='checkingid']").val();
    const btnRecommend = document.getElementById('recommend');
    const btnBookmark = document.getElementById('bookmark');

    //추천
    $("input[id='recommend']").on("click", function () {
        $("#checkrecommend").submit();
        btnRecommend.value="추천 취소";
    });

    $("input[id='unrecommend']").on("click", function () {
        $("#checkunrecommend").submit();
        btnRecommend.value="추천하기";
    });

    //즐겨찾기
    $("input[id='bookmark']").on("click", function () {
        $("#checkbookmark").submit();
        btnBookmark.value = "즐겨찾기 취소";
    });

    $("input[id='unbookmark']").on("click", function () {
        $("#checkunbookmark").submit();
        btnBookmark.value = "즐겨찾기 추가";
    });
    if(check == true){
        // 없는상태 //

    } else{
       // 있는상태 //

    }

});
