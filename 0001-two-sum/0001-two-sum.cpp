class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> mp;
        vector<int> result;
        for(int i=0; i<nums.size(); i++){
            if(mp.find(target - nums[i]) != mp.end()){
                result.push_back(i);
                result.push_back(mp[target-nums[i]]);
                break;
            }
            else {
                mp[nums[i]] = i;
            }
            
        }
        
        
        return result;
    }
};