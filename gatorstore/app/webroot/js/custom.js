/* Finder in 3 Buttons */
$(document).ready(function () {
    $(".col-lg-4").click(function () {
        window.location = $(this).find("a").attr("href");
        return false;
    });
});

//Multi-item Carousel
$(document).ready(function() {
    $('#myCarousel').carousel({
        interval: 10000
    })

    $('#myCarousel').on('slid.bs.carousel', function() {
        //alert("slid");
    });


});


