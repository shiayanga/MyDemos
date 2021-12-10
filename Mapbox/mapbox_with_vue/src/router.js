import DisplayAMap from "@/view/displayAMap";
import HelloWorld from "@/components/HelloWorld";
import addTerrain from "@/components/addTerrain";

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
