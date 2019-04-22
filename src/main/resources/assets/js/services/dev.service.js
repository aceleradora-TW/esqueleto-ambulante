import Http from '../utils/Http'


export const getDev = async (user = 'jeansarlon') => {
        try {
        return await Http.get(`/users/${user}`);
    } catch (error) {
        console.error(error);
    }
}