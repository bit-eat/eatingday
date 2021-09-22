
function loadFile(input) {
    var file = input.files[0];

    var name = document.getElementById('fileName');
    name.textContent = file.name;

    var newImage = document.createElement("img");
    newImage.setAttribute("class", 'img');

    newImage.src = URL.createObjectURL(file);

    newImage.style.width = "50%";
    newImage.style.height = "50%";
    // newImage.style.visibility = "hidden";   //버튼을 누르기 전까지는 이미지 숨기기
    newImage.style.objectFit = "contain";

    var container = document.getElementById('image-show');
    container.appendChild(newImage);
};

function readImage(input) {
    if(input.files && input.files[0]) {
        // FileReader 인스턴스 생성
        const reader = new FileReader()
        // 이미지가 로드가 된 경우
        reader.onload = e => {
            const previewImage = document.getElementById("preview-image")
            previewImage.src = e.target.result
        }
        // reader가 이미지 읽도록 하기
        reader.readAsDataURL(input.files[0])
    }
}
// input file에 change 이벤트 부여
const inputImage = document.getElementsByClassName("input-image")
inputImage.addEventListener("change", e => {
    readImage(e.target)
})

//이미지(png)로 다운로드
function PrintDiv(div){
    div = div[0]
    html2canvas(div).then(function(canvas){
        var myImage = canvas.toDataURL();
        downloadURI(myImage, "저장이미지이름.png")
    });
}

function downloadURI(uri, name){


    var link = document.createElement("a")
    link.download = name;
    link.href = uri;
    document.body.appendChild(link);
    link.click();
}

function cancel(id) {
    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", "/recipe/" + id + "/delete");
    document.body.appendChild(form);
    form.submit();
}

$("input[id='recommend']").on("click", function (){
    $("#checkrecommend").submit();
    $("input[id='recommend']").hide();
    $("input[id='unrecommend']").show();
});

$("input[id='unrecommend']").on("click",function(){
    $("#checkunrecommend").submit();
    $("input[id='recommend']").show();
    $("input[id='unrecommend']").hide();
});
