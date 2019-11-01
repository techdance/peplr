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
	phoneNumber LONG,
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
	discipline VARCHAR(75) null,
	language VARCHAR(75) null,
	location VARCHAR(75) null,
	campus VARCHAR(75) null,
	programLevel VARCHAR(75) null,
	programLength VARCHAR(75) null,
	deliveryMethod VARCHAR(75) null,
	credits VARCHAR(75) null
);