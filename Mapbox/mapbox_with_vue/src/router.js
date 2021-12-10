import DisplayAMap from "@/view/displayAMap";
import HelloWorld from "@/view/HelloWorld";
import addTerrain from "@/view/addTerrain";
import addModel from "@/view/addModel";
import modelPreprocessing from "@/view/modelPreprocessing";
import addGeoJson from "@/view/addGeoJson";

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
        path:'/addModel',
        name:'addModel',
        component:addModel
    },
    {
        path:'/modelPreprocessing',
        name:'modelPreprocessing',
        component:modelPreprocessing
    },
    {
        path:'/addGeoJson',
        name:'addGeoJson',
        component:addGeoJson
    },
    {
        path: '/',
        component: HelloWorld
    }
]
export default routers
