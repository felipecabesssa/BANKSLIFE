<template>
  <div class="main">
      <input type="file" @change="selectImage">
      <button class="btn btn-warning" @click="uploadImage">Upload</button>
  </div>
</template>

<script>
import axios from 'axios'
export default {

    data(){
        return{
            selectedImage:null,
            id: this.$route.params.id
        }
    },

    methods:{
        selectImage(e){
            console.log(e.target.files[0])
            this.selectedImage = e.target.files[0]
        },

        uploadImage(){
            let formData = new FormData()
            formData.append('file', this.selectedImage)
            var token = localStorage.getItem('token')
            const headers = { Authorization: `Bearer ${token}` }
            axios.post('http://localhost:8081/fotos/' + this.id, formData, { headers }).then(resp => {
                console.log(resp.data)
            })
        }
    }

}
</script>

<style>

</style>