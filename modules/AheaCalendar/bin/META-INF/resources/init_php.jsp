<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<!-- fullCalendar -->
<link rel="stylesheet" href="/o/ahea-theme/plugins/fullcalendar/main.min.css">
<link rel="stylesheet" href="/o/ahea-theme/plugins/fullcalendar-daygrid/main.min.css">
<link rel="stylesheet" href="/o/ahea-theme/plugins/fullcalendar-timegrid/main.min.css">
<link rel="stylesheet" href="/o/ahea-theme/plugins/fullcalendar-bootstrap/main.min.css">

<style>
.btn-grey {
    background: #989899;
}
.modal-header {
    color: white;
    font-size: 20px;
    line-height: 1.5;
    padding: 8px;
    text-align: center;
    height: auto;
}
.modal-dialog {
    min-width: 300px;
    max-width: 500px;
    position: relative;
}
.modal-footer {
	justify-content: center;
}
</style>


<script src="/o/ahea-theme/js/jquery-3.1.1.js"></script>
<!-- Bootstrap -->
	<script src="/o/ahea-theme/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- jQuery UI -->
	<script src="/o/ahea-theme/plugins/jquery-ui/jquery-ui.min.js"></script>

	<!-- AdminLTE for demo purposes -->
	<script src="/o/ahea-theme/plugins/demo.js"></script>

<!-- fullCalendar 2.2.5 -->
<script src="/o/ahea-theme/plugins/moment/moment.min.js"></script>
<script src="/o/ahea-theme/plugins/fullcalendar/main.min.js"></script>
<script src="/o/ahea-theme/plugins/fullcalendar-daygrid/main.min.js"></script>
<script src="/o/ahea-theme/plugins/fullcalendar-timegrid/main.min.js"></script>
<script src="/o/ahea-theme/plugins/fullcalendar-interaction/main.min.js"></script>
<script src="/o/ahea-theme/plugins/fullcalendar-bootstrap/main.min.js"></script>

<script>
$(document).ready(function(){
    var calendar = $('#calendar').fullCalendar({
        editable:true,
        header:{
            left:'prev,next today',
            center:'title',
            right:'month,agendaWeek,agendaDay'
        },
        events:"<?php echo base_url(); ?>fullcalendar/load",
        selectable:true,
        selectHelper:true,
        select:function(start, end, allDay)
        {
            var title = prompt("Enter Event Title");
            if(title)
            {
                var start = $.fullCalendar.formatDate(start, "Y-MM-DD HH:mm:ss");
                var end = $.fullCalendar.formatDate(end, "Y-MM-DD HH:mm:ss");
                $.ajax({
                    url:"<?php echo base_url(); ?>fullcalendar/insert",
                    type:"POST",
                    data:{title:title, start:start, end:end},
                    success:function()
                    {
                        calendar.fullCalendar('refetchEvents');
                        alert("Added Successfully");
                    }
                })
            }
        },
        editable:true,
        eventResize:function(event)
        {
            var start = $.fullCalendar.formatDate(event.start, "Y-MM-DD HH:mm:ss");
            var end = $.fullCalendar.formatDate(event.end, "Y-MM-DD HH:mm:ss");

            var title = event.title;

            var id = event.id;

            $.ajax({
                url:"<?php echo base_url(); ?>fullcalendar/update",
                type:"POST",
                data:{title:title, start:start, end:end, id:id},
                success:function()
                {
                    calendar.fullCalendar('refetchEvents');
                    alert("Event Update");
                }
            })
        },
        eventDrop:function(event)
        {
            var start = $.fullCalendar.formatDate(event.start, "Y-MM-DD HH:mm:ss");
            //alert(start);
            var end = $.fullCalendar.formatDate(event.end, "Y-MM-DD HH:mm:ss");
            //alert(end);
            var title = event.title;
            var id = event.id;
            $.ajax({
                url:"<?php echo base_url(); ?>fullcalendar/update",
                type:"POST",
                data:{title:title, start:start, end:end, id:id},
                success:function()
                {
                    calendar.fullCalendar('refetchEvents');
                    alert("Event Updated");
                }
            })
        },
        eventClick:function(event)
        {
            if(confirm("Are you sure you want to remove it?"))
            {
                var id = event.id;
                $.ajax({
                    url:"<?php echo base_url(); ?>fullcalendar/delete",
                    type:"POST",
                    data:{id:id},
                    success:function()
                    {
                        calendar.fullCalendar('refetchEvents');
                        alert('Event Removed');
                    }
                })
            }
        }
    });
});
</script>