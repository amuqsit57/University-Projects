#include <iostream>
using namespace std;


struct Video{

    string title;
    int views;

    Video *next = NULL;

};

struct Server{

    Video *popularCDN = NULL;
    Video *popularCDNLast = NULL;
    Video *video = NULL;
    Video *last = NULL;
};
struct User{

    int id;
    string name;
    string location;

    User* left=NULL;
    User* right=NULL;

};

class Queue{
public:
    static const int size = 20;
    Video *array[size];
    int front=-1;
    int rear=-1;

    bool isFull(){
        if(front == 0 && rear == size-1){
            return true;
        }
        else{
            return false;
        }
    }
    bool isEmpty(){
        if(rear == -1){
            return true;
        }
        else{
            return false;
        }
    }
    void Enqueue(Video* x){
        if(isFull() ){
            cout<< "Array Full";
        }
        else {
            if (isEmpty()) {
                front = rear = 0;
                array[rear] = x;
            }
            else{
                array[++rear]=x;
            }
        }
    }

    Video* Dequeue(){
        if(isEmpty()){

            cout<< "array empty";
            return NULL;
        }
        else{
            Video* video;
            video= array[front];
            if(front == rear){

                front = rear = -1;

            }
            else{

                ++front;

            }
            return video;
        }
    }

    void display(){
        cout << "front "<< front;
        cout << "rear "<< rear;

        for(int i = front; i <=rear;i++ ){
            cout<<" "<<array[i];
        }
    }





};

class Stack{


public:
    static const int  size = 20;
    Video* array[size];
    int top=-1;


    void push(Video* element){

        if(isFull()) {
            cout<< "The Stack Is Full";
        }
        else{
            array[++top]=element;

        }

    }

    Video* pop(){
        Video * x;

        if(isEmpty()){

            cout<< "The Stack Is Empty";
        }
        else{
                x= array[top];
                --top;
        }
        return x;

    }

    bool isEmpty(){

        if(top== -1){
            return true;
        }
        else{
            return false;
        }

    }

    bool isFull(){

        if(top == size -1 ){
            return true;
        }
        else{
            return false;
        }

    }


};
const static int servers = 5;
const static int locations = 6;

//Initiallizing Users With Hashing and BST
const static int userSize  =10;
User* user[userSize];


//Initializing Server
Server *Islamabad = new Server;
Server *Texas = new Server;
Server *Vancouver = new Server;
Server *Jakarta = new Server;
Server *Mumbai = new Server;

Server* Servers[servers] = {Islamabad,Texas,Vancouver,Jakarta,Mumbai};


int serverPaths[locations][locations] = {

        {-1, 10, -1, 5, 7,4},
        {-1, -1, 3, 1, -1,1},
        {-1,3,-1,7,3,6},
        {4,5,8,-1,5,8},
        {3,4,7,8,-1,-1},
        {5,6,7,8,-1,-1}

};

bool hasServer[locations] = {true,true ,true,true,true,false};
int distancesBetweenLocations[locations];
bool alreadyVisited[locations];

//menu
void menuForLogin();
void menuAfterLogin(User*);

//dijkstra Graph
int dijkstra(int[][locations],int[],bool[],int );
int findMinIndex(int[],bool[]);
int findIndexOfShortestDistance(int[] ,int ,int[]);
void bubbleSort(int[] );
void swap(int[],int  , int );

//inserting the video using Linked List
void InsertingAVideoInTheServer(string, int,string );
void enterIntoCDN(Video*);

//Searching the video using linear search and bubble sort and dijkstra
Video* searching(string,string);

//recomendation video using QUEUE;
Queue recommendedVideos(string);
void displayRecommendedVideos(string);


//displaying all videos with limited vision using stacks
Stack displayAllVideos();
void showALlVideos();


//User Functions Using BST and Hashing
void addingUser(int , string  , string );
User* searchingUser(int);
int hashIndex(int);

int main() {

    menuForLogin();
//    User *user1 = new User;
//    user1->id = 23;
//    user1->name = "hin";
//    user1->location ="Islamabad";
//
//    menuAfterLogin(user1);
//
//    InsertingAVideoInTheServer("Taarak Mehta",300,"beijing");
//
//    cout<<Islamabad->video->title;
//
//    InsertingAVideoInTheServer("Taarak ji",2000,"beijing");
////
//    cout<<Islamabad->video->next->title;
//    cout<<Islamabad->video->next->views;
//        Texas->popularCDN = new Video;
//        Texas->popularCDN->title="Babita";
//
//    string locations = "Texas";
//    string titles = "Babita";
//
//    Video* video = searching(locations,titles);
//    if(video != NULL) {
//        cout << "\n" << video->title;
//    }
//
//    cout<<"\nTHs"<<Mumbai->popularCDN->title;
//    cout<<Islamabad->popularCDN->views;

//    displayRecommendedVideos();
}

void menuForLogin(){

    int x;
    cout<< "<<<<<<<  Youtube Networks CDN AND DISTRIBUTED SERVERS   >>>>>>>>\n";
    cout<< "<<<<<<<                     WELCOME                     >>>>>>>>\n";


    cout<< "1. Log In\n";
    cout<< "2. Sign Up\n";

    cin >> x;

    switch (x) {

        case 1: {
            int id;
            cout<< "<<<<<<<PLease Enter>>>>>>>>\n";
            cout<< "PLease Enter Your Id: \n";
            cin >>id;


            bool foundUser;
            User* user1= searchingUser(id);
            if(user1 == NULL){
                foundUser = false;
            }
            else{
                foundUser = true;
            }

            if(foundUser){
                menuAfterLogin(user1);
            }
            else{
                cout<<"\nUser Not Found\n";
                menuForLogin();
            }
        }

        case 2: {
            int id;
            string name;
            string location;
            cout<< "<<<<<<<PLease Enter>>>>>>>>\n";
            cout<< "PLease Enter Your Id: \n";
            cin >>id;

            cout<< "PLease Enter Your Name: \n";
            cin >>name;

            cout<< "PLease Enter Your location: \n";
            cin >>location;

            addingUser(id,name,location);

            cout<<"User Added\n";

            menuForLogin();
        }
        default:menuForLogin();
    }


}
void menuAfterLogin(User* user){

    string userName = user->name;
    string userLocation = user->location;
    int userId = user->id;

    int x;
    cout<< "<<<<<<<  Youtube Networks CDN AND DISTRIBUTED SERVERS   >>>>>>>>\n\n";

    cout<< "1. Upload Video To Server\n";
    cout<< "2. Display All Videos\n";
    cout<< "3. Recommendation (Trending))\n";
    cout<< "4. Search A Specific Video\n";

    cin >> x;

    switch (x) {
        case 1: {
            string title;
            int views;
            string location;
            cout<< "\n<<<<<<<PLease Enter>>>>>>>>\n\n";


            cout<< "\nPLease Title of the video :\n";
            cin >>title;
            cout<< "\nViews on the video:  \n";
            cin >>views;
            cout<< "\nLocation Uploading video from:  \n";
            cin >>location;

            InsertingAVideoInTheServer(title, views , userLocation);

            cout<<"Video Added Successfully\n";

            menuAfterLogin(user);
        }
        case 2: {
            cout<<"\n\n";
            showALlVideos();
            cout<<"\n\n";
            menuAfterLogin(user);
        }

        case 3: {
            cout<<"\n\n";
            displayRecommendedVideos(userLocation);
            cout<<"\n\n";
            menuAfterLogin(user);
        }
        case 4: {
            string title;

            cout<< "\n<<<<<<<PLease Enter>>>>>>>>\n\n";


            cout<< "\nPLease Title of the video to search :\n";
            cin >>title;


            cout<<"\n\n";
            searching(userLocation,title);
            cout<<"\n\n";
//            menuAfterLogin(user);

        }

        default:menuAfterLogin(user);
    }



}

//Users Related Part

//hashIndexCalculator;
int hashIndex(int id){

    return (id % userSize);

}

void addingUser(int id, string name , string location){

    int index = hashIndex(id);


    User *curr = new User;
    curr->id = id;
    curr->name = name;
    curr->location = location;

    User *chosenUser = user[index];
    if( chosenUser == NULL){

        user[index] = curr;
    }
    else{

        User *p=chosenUser, *p2;

        while(p!=NULL){
            p2 = p;
            if(id > p->id){
                p = p->right;
            }
            else{
                p = p->left;
            }
        }

        if(id >p2->id){
            p2->right = curr;
        }
        else{
            p2->left = curr;
        }

    }
}

User* searchingUser(int id){

    int index = hashIndex(id);

    User *chosenUser = user[index];


    User* p=  chosenUser;

    while(p!= NULL && p->id!= id){

        if(id >p->id){
            p = p ->right;
        }
        else{
            p = p -> left;
        }
    }
    return p;

}






//Server And Video Related Part



int EquivalentIndexOfString(string s){

    if(s == "Islamabad"){
        return 0;
    }

    else if(s == "Texas"){
        return 1;
    }

    else if(s == "Vancouver"){
        return 2;
    }

    else if(s == "Jakarta"){
        return 3;
    }

    else if(s == "Mumbai"){
        return 4;
    }
    else if(s == "beijing"){
        return 5;
    }
    else {
        return -1;
    }

}

void InsertingAVideoInTheServer(string title , int views,string location)
{
    int indexOfServer = EquivalentIndexOfString(location);
    if(indexOfServer == -1){
        cout<<"Location Doesnot Exist";
        exit(0);
    }

    // ReSet The Values for Another Iterations

    for(int i = 0 ; i < locations;i++){
        distancesBetweenLocations[i]=-1;
//        alreadyVisitedPath[i]="";
        alreadyVisited[i]=false;
    }

    int chooseStartingPoint = indexOfServer;
    distancesBetweenLocations[chooseStartingPoint]=0;

    int closestServer = dijkstra(serverPaths,distancesBetweenLocations,alreadyVisited,chooseStartingPoint);
    cout<<"CLosest Server"<<closestServer;
    Server* serverClosest = Servers[closestServer];

    //inserting video to the closest server
    Video *curr = new Video;
    curr->title =title;
    curr->views = views;
    if(views>1000) {
        enterIntoCDN(curr);
    }
    if(serverClosest->video==NULL){


//        curr->views = views;
        serverClosest->video = curr;
        serverClosest->last = curr;
    }
    else{
        Video* p = serverClosest->last;
        p->next = curr;
        serverClosest->last = curr;
    }


}

void showALlVideos(){

    Stack s = displayAllVideos();
    Video* videoToBeDisplayed;
    int x = 0;
    char ent;
    do{
        while((x < 5)&& (!(s.isEmpty()))){
            videoToBeDisplayed = s.pop();

            cout<<"Title: "<<videoToBeDisplayed->title<<"    Views: "<<videoToBeDisplayed->views<<"\n";

            x++;
        }
        if(s.isEmpty()){
            cout<<"\n\nNO thing to show\n";
            break;
        }
        cout<<"\n           Show more(y/n)";
        cin>>ent;
        x = 0;
    }
    while (ent =='y');

}

Stack displayAllVideos(){

    Stack s;
    Server* serverToBeChosen;
    Video* videoToBeChosen;
    for(int i = 0 ;i< servers;i++) {
        serverToBeChosen= Servers[i];
        videoToBeChosen = serverToBeChosen->video;

        if(videoToBeChosen!=NULL){
            while(videoToBeChosen!=NULL){

                s.push(videoToBeChosen);
                videoToBeChosen = videoToBeChosen->next;
            }
        }
    }

    return s;

}

void displayRecommendedVideos(string location){

    Queue q = recommendedVideos(location);

    cout<<"Recommended: \n";
    while(!(q.isEmpty())){

        Video * video = q.Dequeue();
        cout<<"Title: "<<video->title<<"    Views: "<<video->views<<"\n";
    }
}

Queue recommendedVideos(string location){

    int indexOfServer = EquivalentIndexOfString(location);
    if(indexOfServer == -1){
        cout<<"Location Doesnot Exist";
        exit(0);
    }

    // ReSet The Values for Another Iterations

    for(int i = 0 ; i < locations;i++){
        distancesBetweenLocations[i]=-1;
//        alreadyVisitedPath[i]="";
        alreadyVisited[i]=false;
    }

    int chooseStartingPoint = indexOfServer;
    distancesBetweenLocations[chooseStartingPoint]=0;
    cout<<"Hi";

    int closestServer = dijkstra(serverPaths,distancesBetweenLocations,alreadyVisited,chooseStartingPoint);
    cout<<"CLosest Server"<<closestServer;
    Server* serverClosest = Servers[closestServer];


    Queue q;

    Video* serverCDNVideos = serverClosest->popularCDN;
    if(serverCDNVideos != NULL) {
        while(serverCDNVideos!=NULL){

            q.Enqueue(serverCDNVideos);

            serverCDNVideos= serverCDNVideos->next;
        }

    }

    return q;
}
void enterIntoCDN(Video *curr){

    for(int i = 0;i < servers;i++) {

        Server* serverToEnterCDNVideoInto =Servers[i];

        if (serverToEnterCDNVideoInto->popularCDN == NULL) {


            serverToEnterCDNVideoInto->popularCDN = curr;
            serverToEnterCDNVideoInto->popularCDNLast = curr;
        } else {
            Video *p = serverToEnterCDNVideoInto->popularCDNLast;
            p->next = curr;
            serverToEnterCDNVideoInto->last = curr;
        }
    }
}

string equivalentStringOfIndex(int index){

    string serverNames[servers] = {"Islamabad","Texas","Vancouver","Jakarta","Mumbai"};
    return serverNames[index];


}

int  dijkstra(int array1[][locations],int dist[],bool alreadyVisited[],int starting){






    for(int j= 0 ; j < locations-1;j++ ){

        int u =findMinIndex(dist,alreadyVisited);
//        alreadyVisitedPath[j]=alreadyVisitedPath[j]+"S"+ to_string(u);

        alreadyVisited[u]=true;


        for(int i = 0; i < locations;i++ ){

            if(!(alreadyVisited[i]) && (array1[u][i]!=-1)&& (dist[u]+array1[u][i]<dist[i] || (dist[i]==-1&&array1[u][i]!=-1))){
                dist[i]=dist[u]+array1[u][i];


//                path[i]=generatePath(i, alreadyVisitedPath);
            }

        }

    }

    cout <<"\n hi";

    //finding minimum index from the distance array and returning it
//    int min = 0;
//    int secondMin = 0;
//    bool alreadyFoundMinWithNoServers[locations]={false,false,false,false,false,false};

    int sortDistance[locations];

    for(int i = 0 ; i  < locations;i++){
        sortDistance[i] = dist[i];
    }

    bubbleSort(sortDistance);

    int n = 0;
    int ind = findIndexOfShortestDistance(sortDistance,n,dist);


    for(int i = 0 ;  i < locations ;i++){
        if(hasServer[ind]){
            return ind;

        }
        n++;
        ind =findIndexOfShortestDistance(sortDistance,n,dist);
    }

//    do{
//
//        for(int i = 0 ; i < locations;i++){
////            if((dist[i]<dist[min]  )&&(alreadyFoundMinWithNoServers[i]==false)){
////                secondMin = min;
////                min = i;
////            }
//
//            if
//        }
//        alreadyFoundMinWithNoServers[min] =true;
//        for(int i = 0 ; i < locations;i++){
//            if(dist[min]<dist[])
//        }
//        cout<<"hidaf"<<min;
//    }while(!hasServer[min]);

    return -1;
}

int findIndexOfShortestDistance ( int sortDistance[],int ind,int dist[]){

    int val = sortDistance[ind];

    for(int i = 0 ;i< locations;i++){
        if(dist[i]==val){
            return i;
        }
    }

}
int findMinIndex(int dist[],bool alreadyVisited[]){
    int min=INT_MAX ;
    int minIndex;
    for(int i = 0; i < locations; i++){

        if( alreadyVisited[i]==false && dist[i]<=min && dist[i]!=-1){
            min = dist[i];
            minIndex = i;
        }

    }
    return minIndex;
}
void bubbleSort(int array[]){

    for(int i = locations;i>0;i--){
        for(int j = 1;j<i;j++ ){
            if(array[j]<array[j-1]){
                swap(array,j,j-1);
            }
        }
    }


}

void swap(int array[],int a , int b){

    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
}


Video* searching(string location,string title){
    int indexOfServer = EquivalentIndexOfString(location);
    if(indexOfServer == -1){
        cout<<"Location Doesnot Exist";
        exit(0);
    }


    // ReSet The Values for Another Iterations

    for(int i = 0 ; i < locations;i++){
        distancesBetweenLocations[i]=-1;
//        alreadyVisitedPath[i]="";
        alreadyVisited[i]=false;
    }

    int chooseStartingPoint = indexOfServer;
    distancesBetweenLocations[chooseStartingPoint]=0;
    cout<<"Hi";
    int closestServer = dijkstra(serverPaths,distancesBetweenLocations,alreadyVisited,chooseStartingPoint);
    cout<<"CLosest Server"<<closestServer;
    Server* serverClosest = Servers[closestServer];

    cout<<"\nhi"<<closestServer;
    if(serverClosest->popularCDN!=NULL){
        cout<<"hi";
        if(serverClosest->popularCDN->title==title) {
            cout << "\nFound Content";

            cout << serverClosest->popularCDN->title;
            cout << serverClosest->popularCDN->views;
            return serverClosest->popularCDN;

        }
        else{
            Video* p = serverClosest->popularCDN;
            while(p->next!=NULL){

                if(p->next->title==title){
                    cout << "\nFound Content";

                    cout << p->next->title;
                    cout << p->next->views;
                    return p->next;

                }
                p= p->next;

            }

        }

    }
    cout<<"ho";

    for(int i = 0; i < servers;i++) {
        Server* serverToBeSearched =  Servers[i];

        if(serverToBeSearched->video!=NULL){

            if(serverToBeSearched->video->title==title) {
                cout << "\nFound Content";

                cout << serverToBeSearched->video->title;
                cout << serverToBeSearched->video->views;
                return serverToBeSearched->video;

            }
            else{
                Video* p = serverToBeSearched->video;
                while(p->next!=NULL){

                    if(p->next->title==title){
                        cout << "\nFound Content";

                        cout << p->next->title;
                        cout << p->next->views;
                        return p->next;

                    }
                    p= p->next;

                }

            }

        }
    }

    return NULL;

}




