create table collaborated_Custom_Calendar (
	PK_calendarEventId LONG not null primary key,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	calendarResourceId LONG,
	timeZoneId VARCHAR(75) null,
	startDate VARCHAR(75) null,
	endDate VARCHAR(75) null,
	startTime VARCHAR(75) null,
	endTime VARCHAR(75) null,
	eventTitle VARCHAR(75) null,
	eventLocation VARCHAR(75) null,
	allDay INTEGER,
	repeat_ VARCHAR(75) null,
	endRepeat VARCHAR(75) null,
	endRepeatDate VARCHAR(75) null,
	alert VARCHAR(75) null,
	url VARCHAR(75) null,
	notes VARCHAR(75) null
);

create table collaborated_Custom_CalendarInvitees (
	PK_calendarEventSubId LONG not null primary key,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	PK_calendarEventId LONG,
	inviteeEmailAddress VARCHAR(75) null,
	invitee LONG,
	status INTEGER
);

create table collaborated_Custom_Workflow (
	workFlowId LONG not null primary key,
	workFlowName VARCHAR(75) null,
	startWorkflowTaskId VARCHAR(75) null,
	comments VARCHAR(75) null,
	isActive LONG,
	createdDate DATE null,
	createdBy LONG
);

create table collaborated_Custom_WorkflowLog (
	logId LONG not null primary key,
	trackingId LONG,
	workflowId LONG,
	workflowTaskId VARCHAR(75) null,
	trasitionId LONG,
	logDescription VARCHAR(75) null,
	comments VARCHAR(75) null,
	assigneeClassPK LONG,
	className VARCHAR(75) null,
	assignedDate DATE null,
	completedDate DATE null,
	createdBy LONG,
	createdDate DATE null
);

create table collaborated_Custom_Workflow_Completed (
	cId LONG not null primary key,
	trackingId LONG,
	workflowId LONG,
	workflowTaskId VARCHAR(75) null,
	trasitionId LONG,
	logDescription VARCHAR(75) null,
	comments VARCHAR(75) null,
	completedDate DATE null,
	userId LONG,
	createdDate DATE null
);

create table collaborated_Custom_Workflow_Task (
	workFlowTaskId VARCHAR(75) not null primary key,
	workFlowId LONG,
	taskName VARCHAR(75) null,
	roleId LONG,
	roleName VARCHAR(75) null,
	comments VARCHAR(75) null,
	createdDate DATE null,
	createdBy LONG
);

create table collaborated_Custom_Workflow_Transition (
	transitionId LONG not null primary key,
	workFlowId LONG,
	workFlowTaskId VARCHAR(75) null,
	transitionName VARCHAR(75) null,
	logDescription VARCHAR(75) null,
	next_WorkFlowTaskId VARCHAR(75) null,
	isEnd LONG,
	comments VARCHAR(75) null,
	createdDate DATE null
);

create table collaborated_applicationLog (
	PK_logId LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	pageName VARCHAR(75) null,
	moduleName VARCHAR(75) null,
	buttonName VARCHAR(75) null,
	projectId LONG,
	interestId LONG,
	comments VARCHAR(75) null
);

create table collaborated_commonWebsserviceAPI (
	commonAPIId LONG not null primary key
);

create table collaborated_communicationPreferences (
	PK_communicationPreferences LONG not null primary key,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	primaryLanguageId LONG,
	primaryLanguageName VARCHAR(75) null,
	secondaryLanguageId LONG,
	secondaryLanguageName VARCHAR(75) null,
	tertiaryLanguageId LONG,
	tertiaryLanguageName VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	phoneNumber VARCHAR(75) null,
	mobileNumber VARCHAR(75) null,
	website VARCHAR(75) null
);

create table collaborated_discussionMessageNotification (
	PK_discussionNotificationId LONG not null primary key,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	PK_projectDiscussionId LONG,
	messageFrom LONG,
	messageTo LONG,
	isRead LONG,
	isRemoved LONG,
	messageTitle VARCHAR(75) null,
	messageContent VARCHAR(75) null,
	emailContent VARCHAR(75) null
);

create table collaborated_labDetailedActivityTable (
	PK_activityTableId LONG not null primary key,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	PK_projectId LONG,
	PK_courseId LONG,
	week LONG,
	courseObjective VARCHAR(75) null,
	learningEnvironmentDesign VARCHAR(75) null,
	activity VARCHAR(75) null,
	content VARCHAR(75) null
);

create table collaborated_labDetailedCourseHours (
	PK_courseHoursId LONG not null primary key,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	PK_projectId LONG,
	PK_courseId LONG,
	numberOfCredits LONG,
	numberOfCourseWeeks LONG,
	courseHoursPerWeek LONG,
	lectureHoursPerWeek LONG,
	labHoursPerWeek LONG,
	independentStudyHoursPerWeek LONG
);

create table collaborated_labDetailedCourseIdentification (
	PK_courseId LONG not null primary key,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	PK_projectId LONG,
	courseTitle VARCHAR(75) null,
	courseNumber VARCHAR(75) null,
	prerequisites VARCHAR(75) null,
	courseDescription VARCHAR(75) null
);

create table collaborated_labDetailedCourseObjectives (
	PK_courseObjectivesId LONG not null primary key,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	PK_projectId LONG,
	PK_courseId LONG,
	courseObjective VARCHAR(75) null
);

create table collaborated_labDetailedCourseResources (
	PK_courseResourceId LONG not null primary key,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	PK_projectId LONG,
	PK_courseId LONG,
	textbokTitle VARCHAR(75) null,
	publisherName VARCHAR(75) null,
	author VARCHAR(75) null,
	isbn VARCHAR(75) null
);

create table collaborated_labDetailedCourseTopics (
	PK_courseTopicsId LONG not null primary key,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	PK_projectId LONG,
	PK_courseId LONG,
	courseTopic VARCHAR(75) null
);

create table collaborated_labDetailedInstructorQualification (
	PK_courseInstructorQualificationId LONG not null primary key,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	PK_projectId LONG,
	PK_courseId LONG,
	instructor1Qualification VARCHAR(75) null,
	instructor2Qualification VARCHAR(75) null
);

create table collaborated_labDetailedLearningEnvironments (
	PK_learningEnvironmentId LONG not null primary key,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	PK_projectId LONG,
	PK_courseId LONG,
	learningEnvironment VARCHAR(75) null
);

create table collaborated_labScreenProjectOverview (
	PK_projectId LONG not null primary key,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	projectOwnerId LONG,
	projectName VARCHAR(75) null,
	projectType VARCHAR(75) null,
	projectDescription VARCHAR(75) null,
	projectDiscipline1 VARCHAR(75) null,
	projectDiscipline2 VARCHAR(75) null,
	projectDiscipline3 VARCHAR(75) null,
	role VARCHAR(75) null,
	projectStartDate VARCHAR(75) null,
	projectEndDate VARCHAR(75) null,
	projectDocumentId LONG,
	percentage LONG,
	interestId LONG,
	projectStatus VARCHAR(75) null
);

create table collaborated_labScreenProjectPartners (
	PK_projectPartnerId LONG not null primary key,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	PK_projectId LONG,
	projectPartnerId LONG,
	isActive LONG
);

create table collaborated_labScreenTask (
	PK_taskId LONG not null primary key,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	PK_projectId LONG,
	milestoneName VARCHAR(75) null,
	taskName VARCHAR(75) null,
	projectAssignedTo LONG,
	taskDescription VARCHAR(75) null,
	taskStatus VARCHAR(75) null,
	dueDate VARCHAR(75) null
);

create table collaborated_languagePreferences (
	PK_languagePreferences LONG not null primary key,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	languageName VARCHAR(75) null
);

create table collaborated_profileAreaofinterest (
	PK_areaofinterest LONG not null primary key,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	projectType VARCHAR(75) null,
	description VARCHAR(75) null,
	language VARCHAR(75) null,
	campus VARCHAR(75) null,
	programLevel VARCHAR(75) null,
	programLength VARCHAR(75) null,
	deliveryMethod VARCHAR(75) null,
	credits VARCHAR(75) null,
	collaborationType VARCHAR(75) null,
	discipline1 VARCHAR(75) null,
	discipline2 VARCHAR(75) null,
	discipline3 VARCHAR(75) null,
	location1 VARCHAR(75) null,
	location2 VARCHAR(75) null,
	location3 VARCHAR(75) null,
	location4 VARCHAR(75) null,
	rangerYearStart INTEGER,
	rangerYearEnd INTEGER,
	rangerMonthStart VARCHAR(75) null,
	rangerMonthEnd VARCHAR(75) null,
	universityName VARCHAR(75) null,
	groupName VARCHAR(75) null
);

create table collaborated_projectDiscussion (
	PK_projectDiscussionId LONG not null primary key,
	groupId LONG,
	createdOn DATE null,
	modifiedDate DATE null,
	interestId LONG,
	projectId LONG,
	senderId LONG,
	description VARCHAR(75) null,
	fileEntryId LONG,
	imageUrl VARCHAR(75) null
);

create table collaborated_projectFilesUpload (
	PK_projectFileId LONG not null primary key,
	groupId LONG,
	createdOn DATE null,
	deletedOn DATE null,
	userId LONG,
	deletedBy LONG,
	PK_projectFolderId LONG,
	fileName VARCHAR(75) null,
	fileEntryId VARCHAR(75) null,
	description VARCHAR(75) null
);

create table collaborated_projectFolderUpload (
	PK_projectFolderId LONG not null primary key,
	groupId LONG,
	createdOn DATE null,
	deletedOn DATE null,
	interestId LONG,
	projectId LONG,
	userId LONG,
	deletedBy LONG,
	parentFolderId LONG,
	folderId LONG,
	folderName VARCHAR(75) null,
	description VARCHAR(75) null
);

create table collaborated_projectInviteTracking (
	PK_projectInvitationId LONG not null primary key,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	projectId LONG,
	inviteFrom LONG,
	inviteTo LONG,
	invitationStatus VARCHAR(75) null,
	isRead LONG,
	isRemoved LONG,
	messageTitle VARCHAR(75) null,
	messageContent VARCHAR(75) null,
	emailContent VARCHAR(75) null
);

create table collaborated_userCredential (
	PK_userCredential LONG not null primary key,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	membership1 VARCHAR(75) null,
	membership2 VARCHAR(75) null,
	membership3 VARCHAR(75) null,
	membership4 VARCHAR(75) null,
	certificate1 VARCHAR(75) null,
	certificate2 VARCHAR(75) null,
	certificate3 VARCHAR(75) null
);

create table collaborated_userInstitutionProfileDetails (
	PK_userInstition LONG not null primary key,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	institutionName VARCHAR(75) null,
	acadeCalendar VARCHAR(75) null,
	departmentdescription VARCHAR(75) null
);

create table collaborated_userInstitutionProfileSubDetails (
	PK_userInstitionSub LONG not null primary key,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	fileId LONG,
	PK_userInstition LONG
);

create table collaborated_userProfessionalBio (
	PK_userProfessionalBio LONG not null primary key,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	areaofexpertise1 VARCHAR(75) null,
	areaofexpertise2 VARCHAR(75) null,
	areaofexpertise3 VARCHAR(75) null,
	experienceyears VARCHAR(75) null,
	cvlink VARCHAR(75) null,
	biodescription VARCHAR(75) null,
	bioDiscipline VARCHAR(75) null
);


create table collaborated_userProfileImage (
	PK_profileImageId LONG not null primary key,
	groupId LONG,
	createdOn DATE null,
	userId LONG,
	fileEntryId VARCHAR(75) null,
	fileEntryUrl VARCHAR(75) null,
	blobData BLOB
);