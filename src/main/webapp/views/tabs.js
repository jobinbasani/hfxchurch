define([
  "views/dashboard",
  "views/members",
  "views/reports",
  "views/events"
],function(dashboard, members, reports, events){

  var cells = [
              dashboard.config,
              members.config,
              events.config,
              reports.config
          ];

          var ui = {
            view:"tabview", cells:cells
          };

	return {
		$ui: ui
	};

});
