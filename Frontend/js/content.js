$(document).ready(function(){
  $('.menu-item').click(function(e){
      e.preventDefault();
      var target = $(this).data('target');
      loadContent(target);
  });
    // Load default content
  loadContent('home');

  function loadContent(target) {
      $('#dynamic-content').load('component/' + target + '.html');
  }
  
});
