function tag(){
    //tagList의 텍스트창에 있는 문자열ㅇ르 가져옴
    const tagOrigin = document.getElementById("tagList").value;

    //공백제거
    const tagDelete = tagOrigin.replace(/(\s*)/g,"");
    //#로 분리해서 리스트로 나눔
    const tagModify = tagDelete.split('#',10);

    // for(var i in tagModify)
    //  console.log(tagModify[i]);


    document.getElementById("tagResult").innerText = tagModify;

    // document.getElementById("tagResult").value = tagModify;

}