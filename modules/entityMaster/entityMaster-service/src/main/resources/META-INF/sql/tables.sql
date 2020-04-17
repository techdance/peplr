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
	website VARCHAR(75) null
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
	rangerMonthEnd VARCHAR(75) null
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
	biodescription VARCHAR(75) null
);