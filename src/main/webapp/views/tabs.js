define([],function(){

  var cells = [
              { header:"<span class='webix_icon fa-film'></span>List", body:{
                  view:"list",
                  template:"#rank#. #title# <div style='padding-left:18px'> Year:#year#, votes:#votes# </div>",
                  type:{
                      height:60
                  },
                  select:true
              }},
              { header:"<span class='webix_icon fa-comments'></span>Form", body:{
                  template:"Place for the form control"
              }},
              { header:"<span class='webix_icon fa-info'></span>About", body:{
                  template:"About the app"
              }}
          ];

          var ui = {
            view:"tabview", cells:cells
          };

	return {
		$ui: ui
	};

});
