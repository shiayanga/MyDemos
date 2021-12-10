import DisplayAMap from "@/view/displayAMap";
import HelloWorld from "@/view/HelloWorld";
import addTerrain from "@/view/addTerrain";

const routers = [
    {
        path:'/displayAMap',
        name:'displayAMap',
        component:DisplayAMap
    },
    {
        path:'/addTerrain',
        name:'addTerrain',
        component:addTerrain
    },
    {
        path: '/',
        component: HelloWorld
    }
]
export default routers
