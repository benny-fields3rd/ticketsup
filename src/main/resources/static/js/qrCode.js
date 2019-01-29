
$(document).ready(() => {


    $(".orderPlaced").on("click" , function () {

    let orderQr = $(".hiddenOrderNum").value ;

    let qrcode = new QRCode("qrOutput", {
        text: orderQr,
        width: 177,
        height: 177,
        colorDark: "#000",
        colorLight: "#fff",
        correctLevel: QRCode.CorrectLevel.H
    });


        $.ajax({
            method: 'POST',
            url: '//formspree.io/pibomoderogue@gmail.com',
            data: qrcode,
            datatype: 'json'
        });
        window.open('https://www.codexworld.com', '_blank');



    })

});