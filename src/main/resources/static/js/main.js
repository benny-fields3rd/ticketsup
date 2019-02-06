$(document).ready(() => {

    $('.slider').slider();
    $('.tabs').tabs();

    const imgPath ="https://image.tmdb.org/t/p/w200";

    const apiKey = "107b035a951eeb077d001e77c3f2a423\n";
        function getTrendingMovie(){
            $.ajax({
                url : "https://api.themoviedb.org/3/trending/movie/week?api_key="+ apiKey,
                type : "get",
                success : function (result) {


                    let htmlForNowShowingMovies = `<div class="row nowShowing">`;
                    for (let i = 0 ; i < 16 ; i++){
                        let movieId = result.results[i].id;
                        let imgLink = result.results[i].poster_path;
                        console.log(movieId);
                        htmlForNowShowingMovies += `<div id="${movieId}" class="col s12  m6 l3 center-align singleMovie">
                                    <img src='${imgPath + imgLink}'  class="imgPoster col s12">
                                    <a class="waves-effect waves-light btn movieBtn col s8 offset-s2" style="margin-top: 5px">Book Movie</a>
                                </div>
                        `
                    }
                    htmlForNowShowingMovies += `</div>`;
                    $("#test-swipe-1").append(htmlForNowShowingMovies);
                },
                error : function (er) {
                    console.log("Error ${er}");
                }
            })
        }
        function getUpcomingMovie(){
            $.ajax({
                url : "https://api.themoviedb.org/3/movie/upcoming?api_key="+ apiKey,
                type : "get",
                success : function (result) {
                    let htmlForUpComingMovies = `<div class="row nowShowing">`;

                    for (let i = 0 ; i < 16 ; i++){

                        let imgLink = result.results[i].poster_path;
                        htmlForUpComingMovies += `<div  id="${result.results[i].id}" class="col s12  m6 l3 center-align singleMovie">
                                    <img src='${imgPath + imgLink}'  class="imgPoster col s12 " />
                                    <a class="waves-effect waves-light  btn movieBtn col s8 offset-s2 " style="margin-top: 5px" >Movie Details</a>
                                </div>
                        `
                    }
                    htmlForUpComingMovies += `</div>`;
                    $("#test-swipe-2").append(htmlForUpComingMovies);
                },
                error : function (er) {
                    console.log("Error ${er}");
                }
            })


        }
        getTrendingMovie();
        getUpcomingMovie();

    $(document).on('click', '.movieBtn', function(){
        let id = $(this).parent().prop("id");

        sessionStorage.setItem('movieId', id);
        window.location = '/movie/'+id;
        return false;
    });


function getMovie() {
    let movieId = sessionStorage.getItem('movieId');
    const imgPathP ="https://image.tmdb.org/t/p/original";
    const imgPathSmall ="https://image.tmdb.org/t/p/w200";




    $.ajax({
        url: ('https://api.themoviedb.org/3/movie/'+ movieId + '?api_key=' + apiKey + '&language=en-US') ,
        type: "get",
        success: function (results) {

        let imgLink = results.poster_path;
            let poster = `
          <div  style="background: linear-gradient(0deg, rgb(0, 0, 0) 5%, rgba(0, 0, 0, 0.45) 92%) center center no-repeat, url( ${imgPathP + results.poster_path}) center top no-repeat rgb(255, 255, 255); height: 100%">
             <div class="container miniMovie" style="height: 100%">
               <div class="row">

                        <div class="col l6 offset-l3 s8 offset-s2">
                        <div class="col l6 hide-on-small-only	">
                            <img src='${imgPathSmall + imgLink}' style="    height: 170px;" id="imgPoster" />
                        </div>
                        <div class="col l6 s12">
                        <h5>${results.title}</h5>

                        <ul id="movieInfo" class="list-group">
                          <li class="list-group-item"><strong>Genre:</strong> ${results.genres[0].name}</li>
                          <li class="list-group-item"><strong>Released:</strong> ${results.release_date}</li>
                          <li class="list-group-item"><strong>Rated:</strong> ${results.vote_average}</li>
                         
                        </ul>
                       </div>
                    </div>
                </div>
                </div>
            </div>

        `;

            let output = `
       
       
            <div class="well">
            <h4>SUMMARY</h4>
            ${results.overview}
        
        </div>`;

            $("#moviePoster").html(poster);
            $('#movie').html(output);
        },
        error : function (er) {
            console .log("Error ${er}");
        }
    })

}
getMovie();

    //THIS IS FOR THE SELECT DATE OF THE MOVIE//

   //  let date = $('#date');
   //  let time = $('#movieTime');
   //
   // if (date.val() == null && time.val() == null) {
   //  $('#btn1').removeAttr(disabled);
   // }
    $(document).ready(function(){
        $('.sidenav').sidenav();
    });

    $(document).ready(function(){
        $('.datepicker').datepicker();
    });

//THIS IS FOR THE SELECT TIME OF THE MOVIE//
    $(document).ready(function(){
        $('select').formSelect();
    });

    $(document).ready(function(){
        $('.sidenav').sidenav();
    });

    function totalCal() {

        let ticketsTotal = $(".ticketsTotal").text();
        console.log(ticketsTotal);

        let totalFoodPrice = 0;
        $(".foodPrice").each(function () {
            let priceStr= $(".foodPrice").text();

            let priceNum = priceStr.slice(1);

            totalFoodPrice += parseInt(priceNum);

        });

        let orderTotal = (parseFloat(ticketsTotal) * 7) + totalFoodPrice;
        console.log(orderTotal);
        $("#total").text(orderTotal);
    }
    totalCal();


    //google sign in
    function onSignIn(googleUser) {
        let profile = googleUser.getBasicProfile();
        console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
        console.log('Name: ' + profile.getName());
        console.log('Image URL: ' + profile.getImageUrl());
        console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
    }


    // /seats index

    function setSize(){
        let curWindowWidth = window.innerWidth;
        let seat = 200;
        let numAvail = Math.round(curWindowWidth / 200);
        let chair = $('.seatBlok');


        for (i = 0; i < numAvail; i++) {
            chair.clone().insertAfter(chair);
        }


        let resizeTimer;
        $(window).resize(function() {
            clearTimeout(resizeTimer);
            resizeTimer = setTimeout(function() {
                function howMany(selectObject) {
                    let numberSelected = 0;
                    for (let i = 0; i < selectObject.options.length; i++) {
                        if (selectObject.options[i].selected) {
                            numberSelected++;
                        }
                    }
                    return numberSelected;
                }



                chair.clone().insertAfter(chair);
            }, 200);
        });


    }

    $(document).ready(setSize);

});