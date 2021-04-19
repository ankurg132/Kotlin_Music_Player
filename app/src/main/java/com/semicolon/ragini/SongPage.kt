package com.semicolon.ragini

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class SongPage : AppCompatActivity() {

    private lateinit var mp: MediaPlayer
    private var totalTime: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.song_page)
        val actionbar = supportActionBar
        //set actionbar title
        var id =intent.getIntExtra("imgID",0)
        Log.d("TAG", "image id is: $id")

        actionbar!!.title = "Song "+(id+1).toString()
        actionbar.setDisplayHomeAsUpEnabled(true)
        val songImage = findViewById<ImageView>(R.id.songImage)
        val lyrics = findViewById<TextView>(R.id.textView3)
        playsong(id,actionbar,songImage,lyrics)
        var textView2 = findViewById<TextView>(R.id.textView2)
        textView2.text = "Lyrics"
        mp.isLooping = false
        mp.setVolume(0.5f, 0.5f)
        totalTime = mp.duration
        mp.start()
        var playBtn = findViewById<Button>(R.id.playBtn)
        playBtn.setBackgroundResource(R.drawable.stop)
        if(id<=9){
            mp.setOnCompletionListener {
                finish()
                intent = Intent(this,SongPage::class.java)
                intent.putExtra("imgID",id+1)
                startActivity(intent)
            }
        }
        var volumeBar = findViewById<SeekBar>(R.id.volumeBar)
        var positionBar = findViewById<SeekBar>(R.id.positionBar)


        // Volume Bar
        volumeBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekbar: SeekBar?, progress: Int, fromUser: Boolean) {
                    if (fromUser) {
                        var volumeNum = progress / 100.0f
                        mp.setVolume(volumeNum, volumeNum)
                    }
                }
                override fun onStartTrackingTouch(p0: SeekBar?) {
                }
                override fun onStopTrackingTouch(p0: SeekBar?) {
                }
            }
        )

        // Position Bar

        positionBar.max = totalTime
        positionBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    if (fromUser) {
                        mp.seekTo(progress)
                    }
                }
                override fun onStartTrackingTouch(p0: SeekBar?) {
                }
                override fun onStopTrackingTouch(p0: SeekBar?) {
                }
            }
        )

        // Thread
        Thread(Runnable {
            while (mp != null) {
                try {
                    var msg = Message()
                    msg.what = mp.currentPosition
                    handler.sendMessage(msg)
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                }
            }
        }).start()
    }

    private fun playsong(id: Int, actionbar: ActionBar, songImage: ImageView, lyrics: TextView) {
        when (id) {
            0 -> {
                mp = MediaPlayer.create(this, R.raw.music)
                actionbar!!.title = "Abhi na jao chodkar"
                lyrics.text = "Abhi na jao chhod kar ke dil abi bhara nahi\n" +
                        "Abhi na jao chhod kar ke dil abi bhara nahi\n" +
                        "\n" +
                        "Abhi abhi to aayi ho, abhi abhi to\n" +
                        "Abhi abhi to aayi ho, bahar banke chhayi ho\n" +
                        "Hawa zara mehak to le, nazar zara behak to le\n" +
                        "Yeh shaam dhal to le zara\n" +
                        "Yeh shaam dhal to le zara\n" +
                        "Yeh dil sambhal to le zara\n" +
                        "\n" +
                        "Main thodi deir jee to loon\n" +
                        "Nashe ke ghoont pee to loon\n" +
                        "Nashe ke ghoont pee to loon\n" +
                        "Abhi to kuchh kaha nahi\n" +
                        "Abhi to kuchh sun nahi\n" +
                        "Abhi na jao chhod kar ke dil abi bhara nahi\n" +
                        "Sitaare jhilmila uthe\n" +
                        "Sitaare jhilmila uthe, charag jagmaga uthe Bas ab na mujhko tokna\n" +
                        "Bas ab na mujhko tokna\n" +
                        "Na badhke raah rokna\n" +
                        "Agar main ruk gayi abhi\n" +
                        "To jaa na paaoongi kabhi\n" +
                        "Yehi kahoge tum sada ke dil abhi nahi bhara\n" +
                        "Jo khatm kisi jagah yeh aisa silsila nahi\n" +
                        "Abhi nahi, abhi nahi, nahi nahi nahi nahi\n" +
                        "Abhi na jao chhod kar ke dil abi bhara nahi\n" +
                        "\n" +
                        "Adhoori aas, adhoori aas chhod ke\n" +
                        "Adhoori pyas chhod ke ao roz yun hi jaaogi\n" +
                        "To kis tarah nibhaaogi\n" +
                        "Ke zindagi ki raah mein\n" +
                        "Jawan dilon ki chaah mein kai makam aayenge\n" +
                        "Jo humko aazmaayenge\n" +
                        "Bura na maano baat ka, yeh pyar hai gila nahi\n" +
                        "Haan yehi kahoge tum sada\n" +
                        "Ke dil abhi nahi bhara\n" +
                        "Haan dil abhi nahi bhara\n" +
                        "Nahi nahi nahi nahi"
                songImage.setImageResource(R.drawable.song1);
            }
            1 -> {
                mp = MediaPlayer.create(this, R.raw.music1)
                actionbar!!.title = "Namo Namo"
                lyrics.text = "Jai ho jai ho Shankara\n" +
                        "(Bholenath Shankara)\n" +
                        "Aadi dev Shankara\n" +
                        "(Hey Shivay Shankara)\n" +
                        "Tere jaap ke bina\n" +
                        "(Bholenath Shankara)\n" +
                        "Chale ye saans kis tarah\n" +
                        "(Hey Shivay Shankara)\n" +
                        "\n" +
                        "Mera karm tu hi jaane\n" +
                        "Kya bura hai kya bhalaa…\n" +
                        "Tere raaste pe main toh\n" +
                        "Aankh moond ke chalaa…\n" +
                        "\n" +
                        "Tere naam ki jot ne\n" +
                        "Saara har liya tamas mera\n" +
                        "(tamas: darkness)\n" +
                        "\n" +
                        "Namo namo ji Shankara\n" +
                        "Bholenath Shankara\n" +
                        "Hey Triloknath Shambhu\n" +
                        "Hey Shivay Shankara\n" +
                        "\n" +
                        "Namo Namo ji Shankara\n" +
                        "Bholenath Shankara\n" +
                        "Rudradev hey Maheshvarah\n" +
                        "\n" +
                        "Srishti ke janam se bhi\n" +
                        "(O o…)\n" +
                        "Pehle tera vaas tha\n" +
                        "(O o…)\n" +
                        "Ye jag rahe ya naa rahe\n" +
                        "(O o…)\n" +
                        "Rahegi teri aastha\n" +
                        "(O o…)\n" +
                        "\n" +
                        "Kya samay… kya pralay\n" +
                        "Dono mein teri mahaanta\n" +
                        "Mahaanta… mahaanta…\n" +
                        "\n" +
                        "Seepiyon ki ontt main\n" +
                        "(Bholenath Shankara)\n" +
                        "Motiyaan ho jis tarah\n" +
                        "(Hey Shivay Shankara)\n" +
                        "Mere mann mein Shankara\n" +
                        "(Bholenath Shankara)\n" +
                        "Tu basa hai uss tarah\n" +
                        "(Hey Shivay Shankara)\n" +
                        "\n" +
                        "Mujhe bharam tha jo hai mera\n" +
                        "Tha nahin kabhi mera…\n" +
                        "\n" +
                        "Arth kya nirarth kya\n" +
                        "Jo bhi hai sabhi tera…\n" +
                        "\n" +
                        "Tere saamne hai jhuka\n" +
                        "Mere sar pe haath rakh tera\n" +
                        "\n" +
                        "Namo Namo ji Shankara\n" +
                        "Bholenath Shankara\n" +
                        "Hey Triloknath Shambhu\n" +
                        "Hey Shivay Shankara\n" +
                        "\n" +
                        "Namo namo ji Shankara\n" +
                        "Bholenath Shankara\n" +
                        "Rudradev hey Maheshvara\n" +
                        "\n" +
                        "Chandrama lalaat pe (O o…)\n" +
                        "Bhasm hai bhujaaon mein (O o…)\n" +
                        "Vastra baagh chhaal ka (O o…)\n" +
                        "Hai khadau paanv mein (O o…)\n" +
                        "\n" +
                        "Pyaas kya ho tujhe\n" +
                        "Ganga hai teri jataaon mein\n" +
                        "Jataaon mein… Jataaon mein…\n" +
                        "\n" +
                        "Doosron ke waaste\n" +
                        "(Bholenath Shankara)\n" +
                        "Tu sadaiv hai jiya\n" +
                        "(Hey Shivay Shankara)\n" +
                        "Maanga kuch kabhi nahi\n" +
                        "(Bholenath Shankara)\n" +
                        "Tune sirf hai diya\n" +
                        "(Hey Shivay Shankara)\n" +
                        "\n" +
                        "Samudra manthan ka tha samay jo aa pada\n" +
                        "Dwand dono lok me vish-amrit pe tha chhida\n" +
                        "Amrit sabhi main baant ke\n" +
                        "Pyala vish ka tune khud piya\n" +
                        "\n" +
                        "Namo Namo ji Shankara\n" +
                        "Bholenath Shankara\n" +
                        "Hey Triloknath Shambhu\n" +
                        "Hey Shivay Shankara\n" +
                        "\n" +
                        "Namo namo ji Shankara\n" +
                        "Bholenath Shankara\n" +
                        "Rudradev hey Maheshvara\n" +
                        "Rudradev hey Maheshvara\n" +
                        "Rudradev hey Maheshvara\n" +
                        "\n" +
                        "\n" +
                        "\n"
                songImage.setImageResource(R.drawable.song2)
            }
            2 -> {
                mp = MediaPlayer.create(this, R.raw.music2)
                actionbar!!.title = "Dekha mene saara jahaan"
                lyrics.text = "dekha maine sara jahan, tujhsa na dekha kahin\n" +
                        "aisa mujhko lagta hain kyun, tu is jahan ki nahi\n" +
                        "ae baharo ki zawani, rup ki malika\n" +
                        "teri aankho se chhalkta, jo nasha halka\n" +
                        "wo nasha to dil pe chhaye\n" +
                        "kaise mujhko hosh aaye\n" +
                        "dar hain tujhse pyaar ho na jaaye\n" +
                        "dekha maine sara jahan, tujhsa na dekha kahin\n" +
                        "aisa mujhko lagta hain kyun, tu is jahan ki nahi\n" +
                        "ae baharo ki zawani, rup ki malika\n" +
                        "teri aankho se chhalkta, jo nasha halka\n" +
                        "wo nasha to dil pe chhaye\n" +
                        "kaise mujhko hosh aaye\n" +
                        "dar hain tujhse pyaar ho na jaaye\n" +
                        "\n" +
                        "dosto se teri baate roz karta hu main\n" +
                        "naam tera ab le le kar aahen bharta hun main\n" +
                        "jabse tu nazar me aai, bekhudi si chhai hain\n" +
                        "har jagah tujhe hi dekhun, teri dhun samai hain\n" +
                        "ae baharo ki zawani, rup ki malika\n" +
                        "teri aankho se chhalkta, jo nasha halka\n" +
                        "wo nasha to dil pe chhaye\n" +
                        "kaise mujhko hosh aaye\n" +
                        "dar hain tujhse pyaar ho na jaaye\n" +
                        "dekha maine sara jahan, tujhsa na dekha kahin\n" +
                        "aisa mujhko lagta hain kyun, tu is jahan ki nahi\n" +
                        "\n" +
                        "sochta hu tujhse agar, main chura lu tujhko\n" +
                        "aaj dil ki gahraai me, aa chhupa lu tujhko\n" +
                        "dillagi na kr tu mujhse, dil se dil mila le\n" +
                        "chain kyun churaya karti, dhadakane chura le aa\n" +
                        "ae baharo ki zawani, rup ki malika\n" +
                        "teri aankho se chhalkta, jo nasha halka\n" +
                        "wo nasha to dil pe chhaye\n" +
                        "kaise mujhko hosh aaye\n" +
                        "dar hain tujhse pyaar ho na jaaye\n" +
                        "dekha maine sara jahan, tujhsa na dekha kahin\n" +
                        "aisa mujhko lagta hain kyun, tu is jahan ki nahi\n" +
                        "ae baharo ki zawani, rup ki malika\n" +
                        "teri aankho se chhalkta, jo nasha halka\n" +
                        "wo nasha to dil pe chhaye\n" +
                        "kaise mujhko hosh aaye\n" +
                        "dar hain tujhse pyaar ho na jaaye"
                songImage.setImageResource(R.drawable.song3)
            }
            3 -> {
                mp = MediaPlayer.create(this, R.raw.music3)
                actionbar!!.title = "Be intehaan"
                lyrics.text = "Suno Na Kahe Kya Suno Na\n" +
                        "Dil Mera Suno Na, Suno Zara\n" +
                        "Teri Baahon Me Mujhe Rehna Hai Raat Bhar\n" +
                        "Teri Baahon Me Hogi Subah\n" +
                        "\n" +
                        "Be Intehaan (Be-Inteha)\n" +
                        "Be Intehaan... Hmmm\n" +
                        "Yun Pyaar Kar (Yun Pyaar Kar) Be Intehaan\n" +
                        "Dekha Karun Saari Umar (Saari Umar)\n" +
                        "Tere Nishaan Be-Intehaan\n" +
                        "Koi Kasar Naa Rahe, Meri Khabar Naa Rahe\n" +
                        "Chhu Le Mujhe Is Kadar Be-Intehaan\n" +
                        "\n" +
                        "Jab Saanson Me Teri Saansen Ghuli Toh\n" +
                        "Phir Sulagne Lage\n" +
                        "Ehsaas Mere Mujhse Kehne Lage\n" +
                        "Haa Baahon Me Teri Aake Jahaan Do\n" +
                        "Yun Simatne Lage\n" +
                        "Sailaab Jaise Koi Behne Lage\n" +
                        "Khoya Hoon Main Aagosh Mein\n" +
                        "Tu Bhi Kahaan Ab Hosh Mein\n" +
                        "Makhmali Raat Ki Ho Naa Subah\n" +
                        "Be Intehaan, Be-Intehaan\n" +
                        "Yun Pyar Kar Be-Inteha\n" +
                        "Hmmm...\n" +
                        "\n" +
                        "Gustakhiyan Kuch Tum Karo\n" +
                        "Kuch Hum Kare Iss Tarah\n" +
                        "Sharrma Ke Do Saaye Hain Jo\n" +
                        "Muh Pher Le Hum Se Yahaan\n" +
                        "\n" +
                        "Haan Chhu Toh Liya Hai Ye Jism Tune\n" +
                        "Rooh Bhi Choom Le\n" +
                        "Alfaaz Bhige Bhige Kyun Hai Mere\n" +
                        "Haan Yun Choor Ho Ke Majboor Ho Ke\n" +
                        "Qatra Qatra Kahe\n" +
                        "Ehsaas Bheege Bheege Kyun Hain Mere\n" +
                        "Do Bekhabar Bheege Badan\n" +
                        "Ho Besabar Bheege Badan\n" +
                        "Le Rahe Raat Bhar Angdaiyaan\n" +
                        "\n" +
                        "Be Inteha, Be Inteha\n" +
                        "Yun Pyar Kar, Be Inteha\n" +
                        "Dekha Karoon Saari Umar\n" +
                        "Tere Nishan, Be-Intehaan\n" +
                        "Koi Kasar Na Rahe, Meri Khabar Na Rahe\n" +
                        "Chhu Le Mujhe Is Kadar Be-Intehaan"
                songImage.setImageResource(R.drawable.song4)
            }
            4 -> {
                mp = MediaPlayer.create(this, R.raw.music4)
                actionbar!!.title = "Lag jaa gale"

                lyrics.text = "Lag Ja Gale Ki Phir\n" +
                        "ye Hasin Raat Ho Na Ho\n" +
                        "shayad Phir Is Janam Mein\n" +
                        "mulakat Ho Na Ho\n" +
                        "lag Jaa Gale ke phir ye hansi raat ho na ho shayad phir is janam Mein mulakat ho na ho... lag ja gale a a aahh hhh hhhhum Ko Mili Hai Aaj\n" +
                        "ye Ghadiya Naseeb Se\n" +
                        "je Bhar Ke Dekh Leejiye\n" +
                        "hamako Kareeb Se\n" +
                        "phir Apke Naseeb Mein\n" +
                        "ye Baat Ho Na Ho\n" +
                        "shayad phir Is Janaam Mein\n" +
                        "mulakaat Ho Na Ho\n" +
                        "pas Aiye Ki Ham Nahin\n" +
                        "ayenge Baar Baar\n" +
                        "bahen Gale Mein Daal Ke\n" +
                        "ham Ro Le Zaar-Zaar\n" +
                        "ankhoon Se Phir Ye\n" +
                        "pyaar Ki Barsaat Ho Na Ho\n" +
                        "shayad Phir Is Janam Mein\n" +
                        "mulakat Ho Na Holag Ja Gale..."
                songImage.setImageResource(R.drawable.song5)
            }
            5 -> {
                mp = MediaPlayer.create(this, R.raw.music5)
                actionbar!!.title = "Tere jaisa yaar kaha"
                lyrics.text = "Tere jaisa yaar kahan\n" +
                        "Kahan aisa yaarana\n" +
                        "Yaad karegi duniya\n" +
                        "Tera mera afsanaTere jaisa yaar kahan\n" +
                        "Kahan aisa yaarana\n" +
                        "Yaad karegi duniya\n" +
                        "Tera mera afsanaMeri zindagi sawaari\n" +
                        "Mujhko gale lagake\n" +
                        "Baitha diya falak pe\n" +
                        "Mujhe khaat se oothake\n" +
                        "Meri zindagi sawaari\n" +
                        "Mujhko gale lagake\n" +
                        "Baitha diya falak pe\n" +
                        "Mujhe khaat se oothake\n" +
                        "Yaara teri yaari ko\n" +
                        "Maine to khuda mana\n" +
                        "Yaad karegi duniya\n" +
                        "Tera mera afsana\nMere dil ki yeh dua hai\n" +
                        "Kabhi door tu na jaaye\n" +
                        "Tere bina ho jeena\n" +
                        "Woh din kabhi na aaye\n" +
                        "Mere dil ki yeh dua hai\n" +
                        "Kabhi door tu na jaaye\n" +
                        "Tere bina ho jeena\n" +
                        "Woh din kabhi na aaye\n" +
                        "Tere sung jeena yahan\n" +
                        "Tere sung mar jaana\n" +
                        "Yaad karegi duniya\n" +
                        "Tera mera afsanaTere jaisa yaar kahan\n" +
                        "Kahan aisa yaarana\n" +
                        "Yaad karegi duniya\n" +
                        "Tera mera afsana"
                songImage.setImageResource(R.drawable.song6)
            }
            6 -> {
                mp = MediaPlayer.create(this, R.raw.music6)
                actionbar!!.title = "Tum hi ho"
                lyrics.text = "Hum Tere Bin Ab Reh Nehi Sakte\n" +
                        "Tere Bina Kya Wajood Mera.\n" +
                        "\n" +
                        "Hum Tere Bin Ab Reh Nehi Sakte\n" +
                        "Tere Bina Kya Wajood Mera,\n" +
                        "Tujhse Juda Gar Ho Jaayenge\n" +
                        "Toh Khud Se Hi Ho Jaayenge Juda\n" +
                        "Kyunki Tum Hi Ho\n" +
                        "Ab Tum Hi Ho\n" +
                        "Zindagi Ab Tum Hi Ho\n" +
                        "Chain Bhi, Mera Dard Bhi,\n" +
                        "Meri Aashiqui Ab Tum Hi Ho.\n" +
                        "\n" +
                        "Tera Mera Rishta Hai Kaisa\n" +
                        "Ek Pal Door Gawaara Nehi\n" +
                        "Tere Liye Har Roz Hai Jeete\n" +
                        "Tujh Ko Diya Mera Waqt Sabhi\n" +
                        "Koi Lamha Mera Na Ho Tere Bina\n" +
                        "Har Saans Pe Naam Tera\n" +
                        "Kyunki Tum Hi Ho\n" +
                        "Ab Tum Hi Ho\n" +
                        "Zindagi Ab Tum Hi Ho\n" +
                        "Chain Bhi, Mera Dard Bhi\n" +
                        "Meri Aashiqui Ab Tum Hi Ho.\n" +
                        "\n" +
                        "Tumhi Ho....Tumhi Ho....!\n" +
                        "Tere Liye Hi Jiya Main\n" +
                        "Khud Ko Jo Yun De Diya Hai\n" +
                        "Teri Wafa Ne Mujhko Sambhala\n" +
                        "Saare Ghamon Ko Dil Se Nikala\n" +
                        "Tere Saath Mera Hai Naseeb Juda\n" +
                        "Tujhe Paake Adhoora Naa Raha Hmm\n" +
                        "Kyunki Tum Hi Ho\n" +
                        "Ab Tum Hi Ho\n" +
                        "Zindagi Ab Tum Hi Ho\n" +
                        "Chain Bhi, Mera Dard Bhi\n" +
                        "Meri Aashiqui Ab Tum Hi Ho,\n" +
                        "Kyunki Tum Hi Ho\n" +
                        "Ab Tum Hi Ho\n" +
                        "Zindagi Ab Tum Hi Ho\n" +
                        "Chain Bhi, Mera Dard Bhi\n" +
                        "Meri Aashiqui Ab Tum Hi Ho.\n"
                songImage.setImageResource(R.drawable.song7)
            }
            7 -> {
                mp = MediaPlayer.create(this, R.raw.music7)
                actionbar!!.title = "Ankh lad jaave"
                lyrics.text = "Shuru!\n" +
                        "\n" +
                        "Jo akh lad jaave\n" +
                        "Saari raat neend na aave\n" +
                        "Mainu bada tadpaave\n" +
                        "Dil chain kahin na paave paave paave x (2)\n" +
                        "\n" +
                        "Khan khan khan khan choodi\n" +
                        "Teri khan khan khan khan khanke re\n" +
                        "Khan khan khan khan khanke\n" +
                        "Vekh vekh ke chehra\n" +
                        "Mera dil yeh dhak dhak dhadke re\n" +
                        "Dil yeh dhak dhak dhadke\n" +
                        "\n" +
                        "Tarsaave tere bin yeh reh na paave\n" +
                        "\n" +
                        "Maahi jo tu na aave aave aave\n" +
                        "Jo akh lad jaave\n" +
                        "Saari raat neend na aave\n" +
                        "Mainu bada tadpaave\n" +
                        "Dil chain kahin na paave paave paave\n" +
                        "\n" +
                        "Leti meri jaan hai teri ek look\n" +
                        "Baaki shaaki gaane ke jaise koi hook\n" +
                        "Dekh ke chanda vi gaya tujhe chhup\n" +
                        "Baat meri sun baby bilkul chup x (2)\n" +
                        "\n" +
                        "Main baawli hoon teri\n" +
                        "Tu jaan hai na meri\n" +
                        "Bas pyaar hi hai maanga\n" +
                        "\n" +
                        "Kis bata ki hai deri\n" +
                        "Baawli hoon teri\n" +
                        "Tu jaan hai na meri\n" +
                        "Bas pyaar hi hai maanga\n" +
                        "Kis bata ki hai deri\n" +
                        "\n" +
                        "Aaja chal tu mere saath yaara chal tu\n" +
                        "Yeh raat kabhi na aave aave aave\n" +
                        "\n" +
                        "Jo akh lad jaave\n" +
                        "Saari raat neend na aave\n" +
                        "Mainu bada tadpaave\n" +
                        "Dil chain kahin na paave paave paave\n" +
                        "\n" +
                        "Saari raat, saari raat, saari raat\n" +
                        "Neend na aave jo akh lad jaave x (2)\n" +
                        "\n" +
                        "Jo akh lad jaave\n" +
                        "Jo akh lad jaave\n" +
                        "\n" +
                        "Khatam\n"
                songImage.setImageResource(R.drawable.song8)
            }
            8 -> {
                mp = MediaPlayer.create(this, R.raw.music8)
                actionbar!!.title = "Manwa Laage"
                lyrics.text = "Manwa laage.. o manwa laage\n" +
                        "Laage re sanware\n" +
                        "Laage re sanware\n" +
                        "Le tera hua jiya ka, jiya ka, jiya ka ye gaanv re\n" +
                        "\n" +
                        "Manwa laage.. o manwa laage\n" +
                        "Laage re sanware\n" +
                        "Laage re sanware\n" +
                        "Le khela maine jiya ka, jiya ka, jiya ka hai daav re\n" +
                        "\n" +
                        "Musaafir hoon main door ka\n" +
                        "Deewana hoon main dhoop ka\n" +
                        "Mujhe na bhaye.. na bhaye, na bhaye chaanv re..\n" +
                        "\n" +
                        "Manwa laage.. o manwa laage\n" +
                        "Laage re sanware\n" +
                        "Laage re sanware\n" +
                        "Le tera hua jiya ka, jiya ka, jiya ka ye gaanv re\n" +
                        "\n" +
                        "Aisi kaisi boli tere naino ne boli\n" +
                        "Jaane kyon main doli\n" +
                        "Aisa lage teri ho li main, tu mera..\n" +
                        "\n" +
                        "Mm.. tune baat kholi kacche dhaago mein piro li\n" +
                        "Baaton ki rangoli se na khelun aise holi main naa tera..\n" +
                        "\n" +
                        "Kisi ka toh hoga hi tu\n" +
                        "Kyun na tujhe main hi jeetun\n" +
                        "Khule khabon me jeete hain, jeete hain baawre\n" +
                        "\n" +
                        "Mann ke dhaage, o mann ke dhaage\n" +
                        "Dhaage pe saanware\n" +
                        "Dhaage pe saanware\n" +
                        "Hai likha mene tera hi, tera hi, tera hi to naam re\n" +
                        "\n" +
                        "Rash nain buniya rash rache\n" +
                        "Dil dhad dhad dhadke shor mache\n" +
                        "Yun dek sek sa lag jaaye\n" +
                        "Main jal jaaun bas pyaar bache\n" +
                        "\n" +
                        "Aise dore daale kaala jaadu naina kaale\n" +
                        "Tere main hawale hua seene se lagale\n" +
                        "Aa.. main tera..\n" +
                        "O.. dono dheeme dheeme jalein\n" +
                        "Aaja dono aise mile\n" +
                        "Zameen pe laage, na tere, na mere paanv re\n" +
                        "\n" +
                        "Manva laage.. manva laage\n" +
                        "Laage re sanware\n" +
                        "Laage re sanware\n" +
                        "Le tera hua jiya ka, jiya ka, jiya ka ye gaanv re\n" +
                        "Rahoon main tere naino ki, naino ki, naino ki chaanv re…\n" +
                        "Le tera hua jiya ka, jiya ka, jiya ka ye gaanv re\n" +
                        "Rahoon main tere naino ki, naino ki, naino ki chaanv re…"
                songImage.setImageResource(R.drawable.song9)
            }

            else -> {
                mp = MediaPlayer.create(this, R.raw.music9)
                actionbar!!.title = "Tip Tip barsa paani"
                lyrics.text = "Tip-tip barsaa paani\n" +
                        "Tip-tip barsaa paani\n" +
                        "Paani ne aag lagaayi\n" +
                        "Aag lagi dil mein to\n" +
                        "Dil ko teri yaad aayi\n" +
                        "Teri yaad aayi to\n" +
                        "Jal uthaa mera bheega badan\n" +
                        "Ab tum hi batao sajan\n" +
                        "Main kya karuNaam tera mere labon pe aayaa tha\n" +
                        "Naam tera mere labon pe aayaa tha\n" +
                        "Ho maine bahaane se tumhe bulaaya tha\n" +
                        "Jhoom kar aa gayaa saavan main kya karu\n" +
                        "Tip-tip barsaa paani\n" +
                        "Paani ne aag lagaayi\n" +
                        "Aag lagi dil mein to\n" +
                        "Dil ko teri yaad aayi\n" +
                        "Teri yaad aayi to\n" +
                        "Jal uthaa mera bheega badan\n" +
                        "Ab tum hi batao sajan\n" +
                        "Main kya karuDuubaa dariyaa mein\n" +
                        "Khadaa main saahil par\n" +
                        "Duubaa dariyaa mein\n" +
                        "Khadaa main saahil par\n" +
                        "Tu bijali bankar giri mere dil par\n" +
                        "Chali aaisi yeh paagal\n" +
                        "Pavan main kya karu\n" +
                        "Tip-tip barsaa paani\n" +
                        "Paani ne aag lagaayi\n" +
                        "Aag lagi dil mein\n" +
                        "Jo toh dil ko teri yaad aayi\n" +
                        "Teri yaad aayi to chha gaya\n" +
                        "Mujhpe deewanapan\n" +
                        "Mere bas mein nahi\n" +
                        "Mera mann main kya karu."
                songImage.setImageResource(R.drawable.song10)
            }
        }
    }

    @SuppressLint("HandlerLeak")
    var handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            var currentPosition = msg.what
            var positionBar = findViewById<SeekBar>(R.id.positionBar)
            var elapsedTimeLabel = findViewById<TextView>(R.id.elapsedTimeLabel)
            var remainingTimeLabel = findViewById<TextView>(R.id.remainingTimeLabel)
            // Update positionBar
            positionBar.progress = currentPosition
            positionBar.max = totalTime
            // Update Labels
            var elapsedTime = createTimeLabel(currentPosition)
            elapsedTimeLabel.text = elapsedTime

            var remainingTime = createTimeLabel(totalTime - currentPosition)
            remainingTimeLabel.text = "-$remainingTime"
        }
    }

    fun createTimeLabel(time: Int): String {
        var timeLabel = ""
        var min = time / 1000 / 60
        var sec = time / 1000 % 60

        timeLabel = "$min:"
        if (sec < 10) timeLabel += "0"
        timeLabel += sec

        return timeLabel
    }

    fun playBtnClick(v: View) {
        var playBtn = findViewById<Button>(R.id.playBtn)
        if (mp.isPlaying) {
            // Stop
            mp.pause()
            playBtn.setBackgroundResource(R.drawable.play)

        } else {
            // Start
            mp.start()
            playBtn.setBackgroundResource(R.drawable.stop)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        mp.stop()
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        mp.stop()
    }
}