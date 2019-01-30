
$(document).ready(() => {


    $(".orderPlaced").on("click" , function () {

    let orderQr = $(".hiddenOrderNum").val() ;

        // sessionStorage.setItem(orderQr , id);

    let qrcode = new QRCode({
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