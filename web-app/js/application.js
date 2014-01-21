$(function(){

    loginFormFancybox();

    $('#searchBtn').click(function(e){
        e.preventDefault();
        var form = $(this).parents('form');
        doSearch(form);
    });

    $('#login-signin').click(function(e) {
        e.preventDefault(e);
        var form = $(this).parents('form');
        doLogin(form);
    });
});

function doLogin(form) {
    var params = $(form).serialize();
    var url = form.attr('action');

    $.post(url, params, function(data){
        if(data.success == true) {
            $('.logoutLink').show();
            $("a#loginLink").hide();
            $.fancybox.close();
        }
        else {
            var $errorDiv = $('.login-error');
            $errorDiv.show();
            $errorDiv.text(data.error);
        }
    });
}

function doSearch(form) {
    var params = $(form).serialize();
    var url = form.attr('action');
    $('.loading').show();
    $('#exportResultLink').hide();

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
                  var img = '<img src="http://farm' + image.farm + '.staticflickr.com/' + image.server + '/' + image.id + '_' + image.secret + '_q.jpg">';
                  var bookmark = '<div class="select-box"><a href="#" class="bookmarkLink" title="' + image.title + '" author="' + image.author +'" source="'+ image.source +'">Add to favourites</a></div>';

                  imageContainer += img;
                  imageContainer += bookmark;
                  imageContainer += '<div>';
                  $imageTileContainer.append(imageContainer);
            });
            $('.loading').hide();
            $('#exportResultLink').show();
            bindAddToFavouritesLink();
        }

    })
}

function bindAddToFavouritesLink() {
    $('.bookmarkLink').click(function(){
          var link = $(this);
          addImagetoDB(link);
    });
}

function addImagetoDB(link) {
    var imageDiv = $(link).parents('.img-container');
    var $img = imageDiv.find('img');
    var $selectDiv = $(link).parents('.select-box');

    var url = $img.attr('src');
    var title =   link.attr('title');
    var author =   link.attr('author');
    var source =   link.attr('source');

    var payload = [ new Object({name: 'url', value: url}), new Object({name: 'title', value:title }), new Object({name: 'author', value:author }), new Object({name: 'source', value:source }) ];

    $.post(addToFavsUrl, payload, function(data){
       if(data.error == 'login'){
           $("a#loginLink").click();
       }
       else if(data.success == true) {
           $selectDiv.css({'background': '#87cefa'});
       }
    });
}

function loginFormFancybox() {
    $("a#loginLink").fancybox();
}
