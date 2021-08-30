var Color = {
    initialize: function() {
        $(document).on("click", ".trow", Color.setColor)
    },
    setColor: function() {

        $(".trow").css('background-color','#fff');
        this.style.backgroundColor = 'yellow';
    }
};
$(document).ready(function(){
    Color.initialize();
});
