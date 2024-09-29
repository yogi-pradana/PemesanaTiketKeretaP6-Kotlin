import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import android.content.Intent
import com.p3b1yogi.pemesanatiketkeretap6.R
import com.p3b1yogi.pemesanatiketkeretap6.SecondActivity

class PesanTiketDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val inflater = requireActivity().layoutInflater

        // Inflate the dialog layout
        val dialogView = inflater.inflate(R.layout.pesan_tiket, null)
        builder.setView(dialogView)
            .setCancelable(true)

        // Handle the existing 'Beli' button action
        dialogView.findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.btn_beli).setOnClickListener {
            // Retrieve data from arguments
            val userName = arguments?.getString("userName") ?: ""
            val selectedTime = arguments?.getString("selectedTime") ?: ""
            val selectedDate = arguments?.getString("selectedDate") ?: ""
            val selectedCity = arguments?.getString("selectedCity") ?: ""

            // Navigate to SecondActivity with the data
            val intent = Intent(requireContext(), SecondActivity::class.java).apply {
                putExtra("nama", userName)
                putExtra("jam", selectedTime)
                putExtra("tanggal", selectedDate)
                putExtra("tujuan", selectedCity)
            }
            startActivity(intent)
            dismiss()
        }

        // Handle the 'Batal' button action
        dialogView.findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.btn_batal).setOnClickListener {
            dismiss() // Just close the dialog
        }

        return builder.create()
    }
}
