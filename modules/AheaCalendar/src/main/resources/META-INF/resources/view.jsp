<%@ include file="/init.jsp" %>

<nav aria-label="breadcrumb">
	<ol class="breadcrumb">
	  <li class="breadcrumb-item"><a href="/home1"> Home</a></li>
	  <li class="breadcrumb-item active" aria-current="page">My Calendar</li>
	</ol>
</nav>

<div class="row row-custom ">
								
<div class="col-lg-12 mb-4">
	<div class="p-3 box-border-radius box-shadow bg-white block-invite">
		<!-- Loader -->
		<div id="FullpageCalendarLoader" class="sectionloader"> 
			<div class="loader"></div>
		</div>
		<div class="inner-wrap">
			<div class="position-relative mb-3 d-flex justify-content-between align-items-start">
				<h3 class="box-subhead"><i class="fas fa-calendar"></i> My Calendar</h3>
				<a class="btn btn-grey btn-w-100" href="javascript:void(0);" data-toggle="modal" data-target="#eventModal">Add New Event</a>
			</div>
			<div class="box-middle">
				<!-- THE CALENDAR -->
        		<div id="calendar"></div>
			</div>
		</div>
	</div>
</div><!-- END COL -->

</div><!-- row -->				

	<!-- event -->
	<div class="modal fade event-modal" id="eventModal" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 id="eventHeader">New Event</h4>
					<div class="toltip-close2 text-right">
						<a href="javascript:void(0);" data-dismiss="modal"><i class="fa fa-times-circle"></i></a>
					</div>	
				</div>
				<div class="modal-body bg-grey">
					<aui:form name="updateCalendarEvent" onSubmit="event.preventDefault();">
						<aui:input type="hidden" name="eventId" label="Event Id" value="" class="form-control"></aui:input>
						<div class="row">
							<div class="col-md-12 mb-2">
								<aui:input type="text" name="eventTitle" label="Event Name" value="" required="true" class="form-control"></aui:input>
							</div>
							<div class="col-md-12 mb-2">
								<aui:input type="text" name="eventLocation" label="Location" value="" required="true" class="form-control"></aui:input>
							</div>
							<div class="col-md-12 mb-2">
								<!-- <aui:input id="eventAllDay" type="checkbox" name="eventAllDay" label="All Day" /> -->
								<aui:input type="hidden" name="iseventAllDay" value="" />
								<span class="checkbox-label position-relative"> 
								<label for="eventAllDay" class="m-0 font-weight-semibold">
										<input name="eventAllDay" id="eventAllDay"
										type="checkbox" class="mr-1 eventAllDay" />All Day
										<div class='check'></div>
								</label>
								</span>
							</div>
							<div class="col-md-12 mb-2">
								<div class="multiColumn datePickerFirst">
									<aui:input type="text" name="startDate" label="Starts" class="form-control" value="" required="true" placeholder="yyyy-mm-dd" autocomplete="off" onkeydown='return false' />
									<aui:input type="text" name="startTime" label="" class="form-control" value="" placeholder="10:00 AM" autocomplete="off" onkeydown='return false' />
								</div>
							</div>
							<div class="col-md-12 mb-2">
								<div class="multiColumn datePickerFirst">
									<aui:input type="text" name="endDate" label="Ends" class="form-control" value="" required="true" placeholder="yyyy-mm-dd" autocomplete="off" onkeydown='return false' />
									<aui:input type="text" name="endTime" label="" class="form-control" value="" placeholder="11:00 AM" autocomplete="off" onkeydown='return false' />
								</div>
							</div>
							<div class="col-md-12 mb-2">
								<aui:select name="eventTimeZone" label="Time Zone">
								    <aui:option value="Abu Dhabi, Muscat">Abu Dhabi, Muscat</aui:option>
									<aui:option value="Adelaide">Adelaide</aui:option>
									<aui:option value="Amman">Amman</aui:option>
									<aui:option value="Amsterdam, Berlin, Bern, Rome, Stockholm, Vienna">Amsterdam, Berlin, Bern, Rome, Stockholm, Vienna</aui:option>
									<aui:option value="Anadyr, Petropavlovsk-Kamchatsky">Anadyr, Petropavlovsk-Kamchatsky</aui:option>
									<aui:option value="Araguaia">Araguaia</aui:option>
									<aui:option value="Ashgabat, Tashkent">Ashgabat, Tashkent</aui:option>
									<aui:option value="Astana">Astana</aui:option>
									<aui:option value="Astrakhan, Ulyanovsk">Astrakhan, Ulyanovsk</aui:option>
									<aui:option value="Asuncion">Asuncion</aui:option>
									<aui:option value="Athens, Bucharest">Athens, Bucharest</aui:option>
									<aui:option value="Atlantic Time (Canada)">Atlantic Time (Canada)</aui:option>
									<aui:option value="Auckland, Wellington">Auckland, Wellington</aui:option>
									<aui:option value="Azores">Azores</aui:option>
									<aui:option value="Baghdad">Baghdad</aui:option>
									<aui:option value="Baku">Baku</aui:option>
									<aui:option value="Bangkok, Hanoi, Jakarta">Bangkok, Hanoi, Jakarta</aui:option>
									<aui:option value="Barnaul, Gorno-Altaysk">Barnaul, Gorno-Altaysk</aui:option>
									<aui:option value="Beijing, Congaing, Hong Kong, Urumqi">Beijing, Congaing, Hong Kong, Urumqi</aui:option>
									<aui:option value="Beirut">Beirut</aui:option>
									<aui:option value="Belgrade, Bratislava, Budapest, Ljubljana, Prague">Belgrade, Bratislava, Budapest, Ljubljana, Prague</aui:option>
									<aui:option value="Bougainville Island">Bougainville Island</aui:option>
									<aui:option value="Brasilia">Brasilia</aui:option>
									<aui:option value="Brisbane">Brisbane</aui:option>
									<aui:option value="Brussels, Copenhagen, Madrid, Paris">Brussels, Copenhagen, Madrid, Paris</aui:option>
									<aui:option value="Cabo Verde Is.">Cabo Verde Is.</aui:option>
									<aui:option value="Cairo">Cairo</aui:option>
									<aui:option value="Canberra, Melbourne, Sidney">Canberra, Melbourne, Sidney</aui:option>
									<aui:option value="Caracas">Caracas</aui:option>
									<aui:option value="Casablanca">Casablanca</aui:option>
									<aui:option value="Cayenne, Fortaleza">Cayenne, Fortaleza</aui:option>
									<aui:option value="Chatham Islands">Chatham Islands</aui:option>
									<aui:option value="Chennai, Kolkata, Mumbai, New Delhi">Chennai, Kolkata, Mumbai, New Delhi</aui:option>
									<aui:option value="Chisinau">Chisinau</aui:option>
									<aui:option value="Chita">Chita</aui:option>
									<aui:option value="Chokurdakh">Chokurdakh</aui:option>
									<aui:option value="City of Buenos Aires">City of Buenos Aires</aui:option>
									<aui:option value="Coordinated Universal Time">Coordinated Universal Time</aui:option>
									<aui:option value="Coordinated Universal Time +12">Coordinated Universal Time +12</aui:option>
									<aui:option value="Coordinated Universal Time +13">Coordinated Universal Time +13</aui:option>
									<aui:option value="Coordinated Universal Time-02">Coordinated Universal Time-02</aui:option>
									<aui:option value="Cuiaba">Cuiaba</aui:option>
									<aui:option value="Damascus">Damascus</aui:option>
									<aui:option value="Darwin">Darwin</aui:option>
									<aui:option value="Dhaka">Dhaka</aui:option>
									<aui:option value="Dublin, Edinburgh, Lisbon, London">Dublin, Edinburgh, Lisbon, London</aui:option>
									<aui:option value="Eastern Time (US &amp; Canada)" selected="">Eastern Time (US &amp; Canada)</aui:option>
									<aui:option value="Ekaterinburg">Ekaterinburg</aui:option>
									<aui:option value="Eucla">Eucla</aui:option>
									<aui:option value="Fiji">Fiji</aui:option>
									<aui:option value="Gaza, Hebron">Gaza, Hebron</aui:option>
									<aui:option value="Georgetown, La Paz, Manaus, San Juan">Georgetown, La Paz, Manaus, San Juan</aui:option>
									<aui:option value="Greenland">Greenland</aui:option>
									<aui:option value="Guam, Port Moresby">Guam, Port Moresby</aui:option>
									<aui:option value="Hairare, Pretoria">Hairare, Pretoria</aui:option>
									<aui:option value="Haiti">Haiti</aui:option>
									<aui:option value="Havana">Havana</aui:option>
									<aui:option value="Helsinki, Kyiv, Riga, Sofia, Tallinn, Vilnius">Helsinki, Kyiv, Riga, Sofia, Tallinn, Vilnius</aui:option>
									<aui:option value="Hobart">Hobart</aui:option>
									<aui:option value="Hovd">Hovd</aui:option>
									<aui:option value="Indiana (East)">Indiana (East)</aui:option>
									<aui:option value="Irkutsk">Irkutsk</aui:option>
									<aui:option value="Islamabad, Karachi">Islamabad, Karachi</aui:option>
									<aui:option value="Istanbul">Istanbul</aui:option>
									<aui:option value="Izhevsk, Samara">Izhevsk, Samara</aui:option>
									<aui:option value="Jerusalem">Jerusalem</aui:option>
									<aui:option value="Kabul">Kabul</aui:option>
									<aui:option value="Kaliningrad">Kaliningrad</aui:option>
									<aui:option value="Kathmandu">Kathmandu</aui:option>
									<aui:option value="Khartoum">Khartoum</aui:option>
									<aui:option value="Kiritimati Island">Kiritimati Island</aui:option>
									<aui:option value="Krasnoyarsk">Krasnoyarsk</aui:option>
									<aui:option value="Kuala Lumpur, Singapore">Kuala Lumpur, Singapore</aui:option>
									<aui:option value="Kuwait, Riyadh">Kuwait, Riyadh</aui:option>
									<aui:option value="Lord Howe Island">Lord Howe Island</aui:option>
									<aui:option value="Magadan">Magadan</aui:option>
									<aui:option value="Mid-Atlantic - Old">Mid-Atlantic - Old</aui:option>
									<aui:option value="Minsk">Minsk</aui:option>
									<aui:option value="Monrovia, Reykjavik">Monrovia, Reykjavik</aui:option>
									<aui:option value="Montevideo">Montevideo</aui:option>
									<aui:option value="Moscow, St. Petersburg">Moscow, St. Petersburg</aui:option>
									<aui:option value="Nairobi">Nairobi</aui:option>
									<aui:option value="Newfoundland">Newfoundland</aui:option>
									<aui:option value="Norfolk Island">Norfolk Island</aui:option>
									<aui:option value="Novosibirsk">Novosibirsk</aui:option>
									<aui:option value="Nuku'alofa">Nuku'alofa</aui:option>
									<aui:option value="Omsk">Omsk</aui:option>
									<aui:option value="Osaka, Sapporo, Tokyo">Osaka, Sapporo, Tokyo</aui:option>
									<aui:option value="Perth">Perth</aui:option>
									<aui:option value="Petropavlovsk-Kamchatsky - Old">Petropavlovsk-Kamchatsky - Old</aui:option>
									<aui:option value="Port Louis">Port Louis</aui:option>
									<aui:option value="Punta Arenas">Punta Arenas</aui:option>
									<aui:option value="Pyongyang">Pyongyang</aui:option>
									<aui:option value="Qyzylorda">Qyzylorda</aui:option>
									<aui:option value="Saint Pierre and Miquelon">Saint Pierre and Miquelon</aui:option>
									<aui:option value="Sakhalin">Sakhalin</aui:option>
									<aui:option value="Salvador">Salvador</aui:option>
									<aui:option value="Samoa">Samoa</aui:option>
									<aui:option value="Santiago">Santiago</aui:option>
									<aui:option value="Sao Tome">Sao Tome</aui:option>
									<aui:option value="Sarajevo, Skopje, Warsaw, Zagreb">Sarajevo, Skopje, Warsaw, Zagreb</aui:option>
									<aui:option value="Saratov">Saratov</aui:option>
									<aui:option value="Seoul">Seoul</aui:option>
									<aui:option value="Solomon Is. New Caledonia">Solomon Is. New Caledonia</aui:option>
									<aui:option value="Sri Jayewardenepura">Sri Jayewardenepura</aui:option>
									<aui:option value="Taipei">Taipei</aui:option>
									<aui:option value="Tbilisi">Tbilisi</aui:option>
									<aui:option value="Tehran">Tehran</aui:option>
									<aui:option value="Tomsk">Tomsk</aui:option>
									<aui:option value="Tripoli">Tripoli</aui:option>
									<aui:option value="Turks and Caicos">Turks and Caicos</aui:option>
									<aui:option value="Ulaanbaatar">Ulaanbaatar</aui:option>
									<aui:option value="Vladivostok">Vladivostok</aui:option>
									<aui:option value="Volgograd">Volgograd</aui:option>
									<aui:option value="West Central Africa">West Central Africa</aui:option>
									<aui:option value="Windhoek">Windhoek</aui:option>
									<aui:option value="Yakutsk">Yakutsk</aui:option>
									<aui:option value="Yangon (Rangoon)">Yangon (Rangoon)</aui:option>
									<aui:option value="Yerevan">Yerevan</aui:option>
								</aui:select>
							</div>
							<div class="col-md-12 mb-2">
								<aui:select name="eventRepeat1" label="Repeat">
									<aui:option value="Never">Never</aui:option>
									<aui:option value="Every Day">Every Day</aui:option>
									<aui:option value="Every Week">Every Week</aui:option>
									<aui:option value="Every 2 Weeks">Every 2 Weeks</aui:option>
									<aui:option value="Every Month">Every Month</aui:option>
									<aui:option value="Every Year">Every Year</aui:option>
								</aui:select>
							</div>
							<div class="col-md-12 mb-2">
								<div class="multiColumn datePickerLast">
									<aui:select name="eventRepeat2" label="End Repeat">
										<aui:option value="Never">Never</aui:option>
										<aui:option value="Every Day">Every Day</aui:option>
										<aui:option value="Every Week">Every Week</aui:option>
										<aui:option value="Every 2 Weeks">Every 2 Weeks</aui:option>
										<aui:option value="Every Month">Every Month</aui:option>
										<aui:option value="Every Year">Every Year</aui:option>
									</aui:select>
									<aui:input type="text" name="endRepeat" label="Ends" class="form-control" value="" placeholder="yyyy-mm-dd" autocomplete="off" onkeydown='return false' />
								</div>
							</div>
							<div class="col-md-12 mb-2">
								<aui:input type="text" name="eventInvitees" label="Invitees" value="" class="form-control" placeholder="jbyrne@nuigalway.ie; rwolff@ahea.edu"></aui:input>
							</div>
							<div class="col-md-12 mb-2">
								<aui:select name="eventAlert" label="Alert">
									<aui:option value="At time of event">At time of event</aui:option>
									<aui:option value="5 minutes before">5 minutes before</aui:option>
									<aui:option value="10 minutes before">10 minutes before</aui:option>
									<aui:option value="15 minutes before" selected="">15 minutes before</aui:option>
									<aui:option value="30 minutes before">30 minutes before</aui:option>
									<aui:option value="1 hour before">1 hour before</aui:option>
									<aui:option value="2 hours before">2 hours before</aui:option>
									<aui:option value="1 day before">1 day before</aui:option>
									<aui:option value="2 days before">2 days before</aui:option>
									<aui:option value="1 week before">1 week before</aui:option>
								</aui:select>
							</div>
							<div class="col-md-12 mb-2">
								<aui:input type="text" name="eventURL" label="URL" value="" class="form-control"></aui:input>
							</div>
							<div class="col-md-12 mb-2">
								<aui:input type="textarea" name="eventNotes" label="Notes" value="" class="form-control"></aui:input>
							</div>
						</div>	
						<div class="w-100 text-right">
							<aui:button value="Cancel" type="reset" class="btn btn-grey" data-dismiss="modal" aria-label="Close" onclick="cancelEvent()"></aui:button>
							<aui:button value="Delete" type="button" class="btn btn-red d-none" onclick="removeEvent()" id="deleteEvent"></aui:button>
							<aui:button value="Save" type="submit"  class="btn btn-blue" id="saveEvent" data-dismiss="modal" aria-label="Close" onclick="saveCalendarEvent()"></aui:button>
						</div>
				</aui:form>
			</div>
		</div>
	</div>
																																							