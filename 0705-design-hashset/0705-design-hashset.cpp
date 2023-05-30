#define ll long long
class MyHashSet {
public:
    vector<ll>num;
    MyHashSet() {
       num=vector<ll>(15630);       
    }
    
    void add(int key) {
        int ind=key/64;
        int rem=key%64;
        long long pos=(1ll<<rem);
        num[ind]|=pos;
    }
    
    void remove(int key) {
        int ind=key/64;
        int rem=key%64;
        long long pos=(1ll<<rem);
        num[ind]&=(~pos);
        
    }
    
    bool contains(int key) {
        int ind=key/64;
        int rem=key%64;
        long long pos=(1ll<<rem);
        return (num[ind]&(pos))!=0;
    }
};
