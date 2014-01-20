$(function(){

    //tileImageslikePinterest();

    $('#searchBtn').click(function(e){
        e.preventDefault();
        var form = $(this).parents('form');
        doSearch(form);
    });
});

function doSearch(form) {
    var params = $(form).serialize();
    var url = form.attr('action');
    $('.loading').show();

    $.get(url, params, function(data) {
        if(data.success == false) {
            $('.loading').hide();
            var $alertDiv =  $('.alert-error');
            $alertDiv.show();
            $alertDiv.html("");
            $alertDiv.text(data.message);
        }
        else {
            var $imageTileContainer = $('#image-tile-container');
            $imageTileContainer.html('');

            $.each(data, function(i,image) {
                  var imageContainer = '<div class="img-container">';
                  var image = '<img src="http://farm' + image.farm + '.staticflickr.com/' + image.server + '/' + image.id + '_' + image.secret + '_q.jpg">';
                  var bookmark = '<div><a href="#">Bookmark</a></div>';
                 imageContainer += image;
                 imageContainer += bookmark;
                 imageContainer += '<div>';
                 $imageTileContainer.append(imageContainer);



            });
            $('.loading').hide();
        }

    })
}

function tileImageslikePinterest() {
    var $container = $('#image-tile-container');
    // initialize
    $container.masonry({
        columnWidth: 100,
        itemSelector: '.img-container',
        "gutter": 5
    });
}
