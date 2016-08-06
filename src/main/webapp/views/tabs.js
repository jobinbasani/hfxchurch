define([
  "views/dashboard",
  "views/members",
  "views/reports"
],function(dashboard, members, reports){

  var cells = [
              dashboard.config,
              members.config,
              reports.config
          ];

          var ui = {
            view:"tabview", cells:cells
          };

	return {
		$ui: ui
	};

});
