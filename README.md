
Command to push the local changes to remote first time.
Create the Repo in Github and follow the below command from local
echo "# Python_Practice" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main 
git remote add origin https://github.com/Ronish009/CORE-JAVA.git
git push -u origin main


Soft reset keep the commit and reset the change to one before
git reset --soft HEAD~1
