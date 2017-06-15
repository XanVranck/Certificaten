@echo off
start "springBoot" cmd /c gradle bootrun
cd C:\wd\certificaten-general\certificaten\certificate-ui\src\
start "serve" cmd /c "serve.bat" 
timeout /t 15 /nobreak > NUL
start chrome http://localhost:4200/