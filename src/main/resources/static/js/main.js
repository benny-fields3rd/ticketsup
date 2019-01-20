
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

                    let firstPoster = result.results[0].backdrop_path ;
                    let secPoster = result.results[1].backdrop_path ;
                    let thirdPoster = result.results[2].backdrop_path ;

                        console.log(result.results[0]);
                    $('#firstPoster').attr("src", imgPath + firstPoster);

                    $('#secPoster').attr("src", imgPath + secPoster);

                    $('#thirdPoster').attr("src", imgPath + thirdPoster);

                    let htmlForNowShowingMovies = `<div class="row nowShowing">`;
                    for (let i = 0 ; i < 15 ; i++){
                        let imgLink = result.results[i].poster_path;
                    console.log(imgLink);
                        htmlForNowShowingMovies += `<div class="col m4 l3">
                                    <img src='${imgPath + imgLink}'  class="imgPoster">
                                    <a onclick="movieSelected('${result.results[i].id}')" class="waves-effect waves-light grey darken-4 btn" href="#">Book Now</a>
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
                        console.log(imgLink);
                        htmlForUpComingMovies += `<div class="col m4 l3">
                                    <img src='${imgPath + imgLink}'  class="imgPoster">
                                    <a onclick="movieSelected('${result.results[i].id}')" class="waves-effect waves-light grey darken-4 btn" href="#">Movie Details</a>
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




function movieSelected(id){
    sessionStorage.setItem('movieId', id);
    window.location = 'movie.html';
    return false;
}

function getMovie() {
    let movieId = sessionStorage.getItem('movieId');

    axios.get('http://www.omdbapi.com?apikey=daef43c2&i=' + movieId)
        .then((response) => {
            console.log(response);
            let movie = response.data;

            let output = `
        <div class="row">
          <div class="col-md-4">
            <img src="${movie.Poster}" class="thumbnail">
          </div>
          <div class="col-md-8">
            <h2>${movie.Title}</h2>
            <ul class="list-group">
              <li class="list-group-item"><strong>Genre:</strong> ${movie.Genre}</li>
              <li class="list-group-item"><strong>Released:</strong> ${movie.Released}</li>
              <li class="list-group-item"><strong>Rated:</strong> ${movie.Rated}</li>
              <li class="list-group-item"><strong>IMDB Rating:</strong> ${movie.imdbRating}</li>
              <li class="list-group-item"><strong>Director:</strong> ${movie.Director}</li>
              <li class="list-group-item"><strong>Writer:</strong> ${movie.Writer}</li>
              <li class="list-group-item"><strong>Actors:</strong> ${movie.Actors}</li>
            </ul>
          </div>
        </div>
        <div class="row">
          <div class="well">
            <h3>Plot</h3>
            ${movie.Plot}
            <hr>
            <a href="http://imdb.com/title/${movie.imdbID}" target="_blank" class="btn btn-primary">View IMDB</a>
            <a href="index.html" class="btn btn-default">Go Back To Search</a>
          </div>
        </div>
      `;

            $('#movie').html(output);
        })
        .catch((err) => {
            console.log(err);
        })
}
});