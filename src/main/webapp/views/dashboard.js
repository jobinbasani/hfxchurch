define([],function(){

  var dashboardConfig = { header:"<span class='webix_icon fa-film'></span>Dashboard", body:{
      view:"list",
      template:"#rank#. #title# <div style='padding-left:18px'> Year:#year#, votes:#votes# </div>",
      type:{
          height:60
      },
      select:true
  }};
  return { config: dashboardConfig};
});
