<!DOCTYPE html>
<html>
<head>

    <link href="${resource(dir: 'css', file: 'fullcalendar.css')}" rel="stylesheet" />
    <link href="${resource(dir: 'css', file: 'fullcalendar.print.css')}" rel="stylesheet" />
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />


    <script src="${resource(dir: "js", file: "jquery.min.js")}"></script>
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    <script src="${resource(dir: "js", file: "jquery-ui.custom.min.js")}"></script>
    <script src="${resource(dir: "js", file: "fullcalendar.min.js")}"></script>



    <script>
        $(document).ready(function() {

            $( "#dialog" ).dialog({
                autoOpen: false,
                show: {
                    effect: "blind",
                    duration: 1000
                },
                hide: {
                    effect: "explode",
                    duration: 1000
                }
            });

            $('#calendar').fullCalendar({
                dayClick: function(date) {
                    //var d = $('#calendar').fullCalendar('getDate');
//                    $("#fecha").val(date); //datpicker("setDate", startDate);
                    $( "#dialog" ).dialog( "open" );
                },
                editable: true,

                events: "http://localhost:8080/practica9_20090133/Evento/listaEventos",

                eventDrop: function(event, delta) {
                    alert(event.title + ' was moved ' + delta + ' days\n' +
                            '(should probably update your database)');
                },

                loading: function(bool) {
                    if (bool) $('#loading').show();
                    else $('#loading').hide();
                }

            });

        });

    </script>
    <style>

    body {
        margin-top: 40px;
        text-align: center;
        font-size: 14px;
        font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
    }

    #loading {
        position: absolute;
        top: 5px;
        right: 5px;
    }

    #calendar {
        width: 900px;
        margin: 0 auto;
    }

    </style>
</head>
<body>
    <h2 align="center">Calendario de Actividades</h2>
    <div>
        <g:if test="${flash.validacionForm == false}">
            <div class="box" align="center">
                <div style="background-color: greenyellow">
                    ${flash.mensajeValidacionForm}
                </div>
            </div>
        </g:if>
        <g:elseif test="${flash.validacionForm == true}">
            <div class="box" align="center">
                <div style="background-color: indianred">
                    ${flash.mensajeValidacionForm}
                </div>
            </div>
        </g:elseif>
    </div>

    <div id="dialog" title="Agregar Evento">
        <g:form action="gregarEvento" controller="Evento" id="agregarEvento" name="agregarEvento">
            <strong>Titulo: </strong><input type="text" name="titulo" required="true"><br>
            <Strong>Fecha Inicio: </Strong><br>
            <g:datePicker name="fechaInicio" id="fecha"></g:datePicker><br>
            %{--<input type="text" name="fechaInicio" id="fecha" /><br>--}%
            <input type="submit" value="agregar"/>
        </g:form>
    </div>

    <div id='calendar'></div>
</body>
</html>
