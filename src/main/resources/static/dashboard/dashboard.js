$(document).ready(function() {
    console.log("inside of here")
    $('.delete-button').click(function() {
        $(this).closest('tr').remove();
    });
});