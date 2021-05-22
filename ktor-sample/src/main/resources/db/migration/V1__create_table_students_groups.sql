CREATE TABLE STUDENTS(
                         ID SERIAL PRIMARY KEY,
                         NAME TEXT NOT NULL,
                         GROUPID INTEGER NOT NULL
);

CREATE TABLE GROUPS(
                         ID SERIAL PRIMARY KEY,
                         TITLEFAC TEXT NOT NULL,
                         NUMBER INTEGER NOT NULL
)