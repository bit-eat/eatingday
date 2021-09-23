$(document).ready(function() {
   
   var check = $("input[id='checkid']").val();
   var checking = $("input[id='checkingid']").val();
   //추천,즐겨찾기
   if(check==3){
      $("input[id='recommend']").hide();
      $("input[id='unrecommend']").hide();
   } else if(check==1){
      $("input[id='recommend']").hide();
      $("input[id='unrecommend']").show();
   } else if(check==0){
      $("input[id='recommend']").show();
      $("input[id='unrecommend']").hide();
   }

   
   if(checking==3){
      $("input[id='bookmark']").hide();
      $("input[id='unbookmark']").hide();
   } else if(checking==1){
      $("input[id='recommend']").hide();
      $("input[id='unrecommend']").show();
   } else if(checking==0){
      $("input[id='bookmark']").show();
      $("input[id='unbookmark']").hide();
   }
   //추천
   $("input[id='recommend']").on("click",function(){
      $("#checkrecommend").submit();
      $("input[id='recommend']").hide();
      $("input[id='unrecommend']").show();
   });
   
   $("input[id='unrecommend']").on("click",function(){
      $("#checkunrecommend").submit();
      $("input[id='recommend']").show();
      $("input[id='unrecommend']").hide();
   });
   
   //즐겨찾기
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
   
   
});
