
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
                    // let firstPoster = result.results[0].backdrop_path ;
                    // let secPoster = result.results[1].backdrop_path ;
                    // let thirdPoster = result.results[2].backdrop_path ;
                    //
                    // $('#firstPoster').attr("src", imgPath + firstPoster);
                    //
                    // $('#secPoster').attr("src", imgPath + secPoster);
                    //
                    // $('#thirdPoster').attr("src", imgPath + thirdPoster);

                    let htmlForNowShowingMovies = `<div class="row nowShowing">`;
                    for (let i = 0 ; i < 15 ; i++){
                        let movieId = result.results[i].id;
                        let imgLink = result.results[i].poster_path;
                        console.log(movieId);

                        htmlForNowShowingMovies += `<div id="${movieId}" class="col s2  m4 l3 center-align singleMovie">
                                    <img src='${imgPath + imgLink}'  class="imgPoster">
                             <a class="  waves-effect waves-light btn movieBtn" >Book Movie</a>
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

                    for (let i = 0 ; i < 15 ; i++){

                        let imgLink = result.results[i].poster_path;
                        htmlForUpComingMovies += `<div  id="${result.results[i].id}" class="col s2 m4 l3">
                                    <img src='${imgPath + imgLink}'  class="imgPoster">
                                    <a class="waves-effect waves-light  btn movieBtn"  >Movie Details</a>
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

    $.ajax({
        url: ('https://api.themoviedb.org/3/movie/'+ movieId + '?api_key=' + apiKey + '&language=en-US') ,
        type: "get",
        success: function (results) {

            let output = `
       
        <div class="row">
          <div class="col s12 m4">
            <img src="${imgPath + results.poster_path}" class="thumbnail">
          </div>
          <div class="col s12 m8">
            <h2>${results.title}</h2>
            <ul class="list-group">
              <li class="list-group-item"><strong>Genre:</strong> ${results.genres[0].name}</li>
              <li class="list-group-item"><strong>Released:</strong> ${results.release_date}</li>
              <li class="list-group-item"><strong>Rated:</strong> ${results.vote_average}</li>
              <li class="list-group-item"><strong>Production Company:</strong> ${results.production_companies[0].name}</li>
              <li class="list-group-item">${movieId}</li>
            </ul>
            <div class="well">
            <h3>Plot</h3>
            ${results.overview}
          </div>
            </form>
          </div>
        </div>
     
        
      `;
            $('#movie').html(output);
        },
        error : function (er) {
            console .log("Error ${er}");
        }
    })

}
getMovie();

    //THIS IS FOR THE SELECT DATE OF THE MOVIE//

   //  var date = $('#date');
   //  var time = $('#movieTime');
   //
   // if (date.val() == null && time.val() == null) {
   //  $('#btn1').removeAttr(disabled);
   // }


    $(document).ready(function(){
        $('.datepicker').datepicker();
    });

//THIS IS FOR THE SELECT TIME OF THE MOVIE//
    $(document).ready(function(){
        $('select').formSelect();
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

        let orderTotal = (parseInt(ticketsTotal) * 7) + totalFoodPrice;
        console.log(orderTotal);
        $("#total").text(orderTotal);
    }
    totalCal()


});