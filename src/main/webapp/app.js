/*
	App configuration
*/

define([
	"libs/webix-mvc-core/core",
	"libs/webix-mvc-core/plugins/menu",
], function(
	core, menu
){

	//configuration
	var app = core.create({
		id:			"hfxchurch",
		name:		"Holy Family Church",
		version:	"0.1.0",
		debug:		true,
		start:		"/top/tabs"
	});

	app.use(menu);



	return app;
});
