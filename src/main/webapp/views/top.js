define([
	"app"
],function(app){

	var header = {
		type:"header", template:app.config.name, borderless:true
	};

	var ui = {
  type : "space",
  rows : [
    {
      view : "toolbar",
      elements : [
        header,
        { view : "label", label : "User", align : "right", id : "usernameLabel" }
      ]
    },
		{
			$subview:true
		}
  ]
};

	return {
		$ui: ui
	};
});
